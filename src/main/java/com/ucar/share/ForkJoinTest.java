package com.ucar.share;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest<V> extends RecursiveTask {
    private static final int THRESHOLD = 2;// 阈值,数量小于它的时候直接计算
    private static final int TASKNUM = 2; // 任务数
    private int start = 0;
    private int end = 0;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {
        int sum = 0;// 计算结果
        boolean cancompute = end - start <= THRESHOLD;
        if (cancompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else { // 执行ForkJoin任务
            int middle = (start + end) / TASKNUM; // 分割
            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待完成
            int leftResult = (Integer) leftTask.join();
            int rightResult = (Integer) rightTask.join();
            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        // 生成一个计算的任务
        ForkJoinTest<Integer> task = new ForkJoinTest<Integer>(1, 10);
        // 执行任务
        Future<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

