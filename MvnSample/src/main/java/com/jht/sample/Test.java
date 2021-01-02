package com.jht.sample;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

public class Test {
	public static int[] sort(int[] arr) {
		for (int i=arr.length; i>0; i--) {
			moveMax(arr, i);
		}
		
		return arr;
	}
	
	public static int[] moveMax(int[] arr, int len) {
		for (int i=0; i<len-1; i++) {
			if (arr[i] < arr[i+1]) {
				int t = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = t;
			}
		}
		return arr;
	}
	
	public static void print(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			if (i < arr.length - 1)
				System.out.print(arr[i] + ", ");
			else
				System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2, 4, 8, 5, 3, 6};
		print(sort(a));
    }
}
