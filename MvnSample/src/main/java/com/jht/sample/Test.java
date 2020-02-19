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
	public static void main(String[] args) throws InterruptedException {

//		String ids = Arrays.asList(Locale.getAvailableLocales()).stream()
//				.map(Locale::toString)
//				.filter(l -> l.contains("zh"))
//				.collect(Collectors.joining(", "));
//		System.out.println(ids);
		
		byte[] bytes = {(byte) 0b10101100, (byte) 0b00101000};
		BitSet primes = BitSet.valueOf(bytes);
		System.out.println(Integer.toString(bytes[0], 2));
		System.out.println(Integer.toString(bytes[1], 2));
		System.out.println(primes);
    }
}
