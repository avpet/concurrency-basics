# Очень общий план

Литература:

* JCP - ["Java Concurrency in Practice"](https://drive.google.com/file/d/0B9iW9CFFLZjuT3dHRGZlcG4teGs/view?usp=sharing) - наверное, самая лучшая книга по сей день по concurrency в Java. Там нету, правда, самых новых штук, вроде `ForkJoin`.
* JTP - ["Java Thread Programming"](https://drive.google.com/file/d/0B9iW9CFFLZjueWRDYXpoWURQX0E/view?usp=sharing) - несколько устаревшая, поскольку освещает еще Java 1.4, но тоже есть что почерпнуть в смысле основ.
* CPAPF - ["Concurrent Programming: Algorithms, Principles, and Foundations"](https://drive.google.com/file/d/0B9iW9CFFLZjuZV9qTU1VUWswdU0/view?usp=sharing) - это книга чисто теоретическая, совсем не по Java, но там можно найти формальные  определения, если нужно, поскольку работа фундаментальная.

1. Определения , преимущества использования нескольких процессоров:
	* [http://programmers.stackexchange.com/questions/97615/what-can-multiple-threads-do-that-a-single-thread-cannot](http://programmers.stackexchange.com/questions/97615/what-can-multiple-threads-do-that-a-single-thread-cannot) 
	* [https://www.quora.com/What-are-some-real-life-examples-of-multi-threading-as-we-study-in-Java](https://www.quora.com/What-are-some-real-life-examples-of-multi-threading-as-we-study-in-Java) 
	* [https://github.com/yjfox/-Java-Concurrency-in-Practice-Source-Code](https://github.com/yjfox/-Java-Concurrency-in-Practice-Source-Code)

2. shared state, synchronization, mutual exclusion, монитор, проблемы синхронизации, volatile, wait/notify 
	* [https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html](https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html)
	* JCP, chapter 2
	* JTP, chapter 7

3. Lock objects [http://stackoverflow.com/questions/4201713/synchronization-vs-lock](http://stackoverflow.com/questions/4201713/synchronization-vs-lock)
4. other synchronization primitives - JCP 5.5
5. Concurrency problems 
	* Deadlock
	* Liveness
	* Priority inversion
	* Resource starvation [https://en.wikipedia.org/wiki/Starvation_%28computer_science%29](https://en.wikipedia.org/wiki/Starvation_%28computer_science%29)

6. concurrent collections; producer consumer, blocking queues - JCP 5.1, 5.2, 5.3

7. Task execution - executors, fork-join

8. Lock-free algorithms 
	* [https://en.wikipedia.org/wiki/Non-blocking_algorithm](https://en.wikipedia.org/wiki/Non-blocking_algorithm)
	* [http://stackoverflow.com/questions/5680869/are-lock-free-algorithms-really-more-performant-than-their-lock-full-counterpart](http://stackoverflow.com/questions/5680869/are-lock-free-algorithms-really-more-performant-than-their-lock-full-counterpart)
	* [http://mechanical-sympathy.blogspot.com/2013/08/lock-based-vs-lock-free-concurrent.html](http://mechanical-sympathy.blogspot.com/2013/08/lock-based-vs-lock-free-concurrent.html)

9. Alternative approaches - Hoare's CSPs, actors: [https://news.ycombinator.com/item?id=7612775](https://news.ycombinator.com/item?id=7612775)



Привет, Витя.

Первый вариант - общий план, как я в сумме это приблизительно вижу, вот - https://github.com/avpet/concurrency-basics/blob/master/posts/_posts/2016-01-10-basic-concurrency-plan.markdown . Вообще, надо будет созвониться, конечно, и обговорить; предлагаю завтра, в течение дня, начиная с 11:30 по Киеву, ті напиши, и созвонимся в скайпе.
