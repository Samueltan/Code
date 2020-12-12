package com.sample.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CakeUnionUtil{
    public static void main(String[] args) {
        List<StuffedChocolateCake> firstList = Arrays.asList(new StuffedChocolateCake(1), new StuffedChocolateCake(3));
        List<ChocolateCake> secondList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));
        List<VanillaCake> thirdList = Arrays.asList(new VanillaCake(11), new VanillaCake(22));

//        List<ChocolateCake> chocolateUnion = CakeUnionUtil.union(firstList, secondList);
//        List<Cake> fullUnion = CakeUnionUtil.union(chocolateUnion, thirdList);
//        assertThat(fullUnion)
//                .containsExactly(new StuffedChocolateCake(1), new StuffedChocolateCake(3), new ChocolateCake(2), new ChocolateCake(20),
//                        new VanillaCake(11), new VanillaCake(22));

    }

//    public static<S extends Cake, T extends S> List<S> union(S[] list1, T[] list2) {
//        List<S> result = new ArrayList<>();
//        for(S s : list1) {
//            result.add(s);
//        }
//        for(T t : list2) {
//            result.add(t);
//        }
//        return result;
////        return union(list1.toArray((S[])new Object[list1.size()]), (T[])(new Object[list1.size()]));
//    }

    public static<R extends Cake, S extends R, T extends R> List<R> union(S[] list1, T[] list2) {
        List<R> result = new ArrayList<>();
        for(S s : list1) {
            result.add(s);
        }
        for(T t : list2) {
            result.add(t);
        }
        return result;
//        return union(list1.toArray((S[])new Object[list1.size()]), (T[])(new Object[list1.size()]));
    }
}

class Cake {
    int amount;

    public Cake(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return amount == cake.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
class ChocolateCake extends Cake {
    public ChocolateCake(int amount) {
        super(amount);
    }
}
class StuffedChocolateCake extends ChocolateCake {
    public StuffedChocolateCake(int amount) {
        super(amount);
    }
}
class VanillaCake extends Cake {
    public VanillaCake(int amount) {
        super(amount);
    }
}
