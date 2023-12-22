package service;

import benchmark.Benchmarked;

public interface IService {
    @Benchmarked
    void do1();

    @Benchmarked
    void do2();
}
