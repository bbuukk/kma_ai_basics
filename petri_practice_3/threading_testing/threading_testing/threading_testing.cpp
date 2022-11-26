#include <iostream>
#include <thread>

void foo();

int main()
{
    std::cout << "Hello World of Concurrency!\n";

    std::thread m_fst_thread(foo);
    m_fst_thread.join();

    std::cout << "See ya, World of Concurrency!\n";
}

void foo() {
    std::cout << "Threads testing in C++" << "\n";
    std::cout << "It's my and my friends victory!!!" << "\n";
}