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

    public static<S extends Cake, T extends Cake> List<Cake> union(List<S> list1, List<T> list2) {
        List<Cake> result = new ArrayList<>();
        for(S s : list1) {
            result.add(s);
        }
        for(T t : list2) {
            result.add(t);
        }
        return result;
    }

//    public static<S extends Cake, T extends S> List<S> union(List<T> list1, List<S> list2) {
//        List<S> result = new ArrayList<>();
//        for(T t : list1) {
//            result.add(t);
//        }
//        for(S s : list2) {
//            result.add(s);
//        }
//        return result;
//    }
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
