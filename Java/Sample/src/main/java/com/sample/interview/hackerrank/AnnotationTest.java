package com.sample.interview.hackerrank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) {
        String[] lines = {
            "SENIOR 75",
            "JUNIOR 45",
            "SENIOR 40"
        };

        Class fmClass = FamilyMember.class;
        Method[] methods = fmClass.getDeclaredMethods();

        for (String s : lines) {
            String[] line = s.split(" ");
            String role = line[0];
            int spend = Integer.parseInt(line[1]);

            for (Method m : methods) {
                Class fbClass = FamilyBudget.class;
                if (m.isAnnotationPresent(fbClass)) {
                    FamilyBudget fb = (FamilyBudget) m.getAnnotation(fbClass);
                    String userRole = fb.userRole();
                    int budgetLimit = fb.budgetLimit();
                    if (role.equals(userRole)) {
                        if (spend > budgetLimit) {
                            System.out.println("Over budget limit!");
                        } else {
                            try {
                                m.invoke(fmClass.newInstance(), budgetLimit, spend);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}

class FamilyMember {
    @FamilyBudget(userRole="SENIOR", budgetLimit=100)
    void seniorMember(int budget, int spend) {
        System.out.println("Senior member");
        System.out.println("Spent: " + spend);
        System.out.println("Money left: " + (budget - spend));
    }

    @FamilyBudget(userRole="JUNIOR", budgetLimit=50)
    void juniorMember(int budget, int spend) {
        System.out.println("Junior member");
        System.out.println("Spent: " + spend);
        System.out.println("Money left: " + (budget - spend));
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
    String userRole() default "GUEST";
    int budgetLimit() default 50;
}

