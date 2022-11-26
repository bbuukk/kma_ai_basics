#include <windows.h>
#include <stdio.h>
#include <tchar.h>
#include <iostream>
#include <fstream>
#include <chrono>
#include <thread>

void start_reqs_screen();

int main(void)
{
    std::cout << "Part 1\n";
    start_reqs_screen();

    const char* path = "C:\\mystaff\\uni\\moop\\foo.txt";
    std::ofstream file(path);

    for (size_t i = 0; i < 10; i++)
    {
        file << "Glory To Ukraine!\n" << std::flush;

        #ifndef NDEBUG
        std::cout << "Writed" << "\n";
        #endif 

        std::chrono::seconds dura(1);
        std::this_thread::sleep_for(dura);
    }

    file.close();

    return 0;
}


void start_reqs_screen() {

    STARTUPINFO si;
    PROCESS_INFORMATION pi;

    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));
    // Start the child process. 
    if (!CreateProcess(L"C:\\mystaff\\uni\\OSHI\\_NaUKMA_oshi_practices\\petri_practice_3\\test_two_screen_2\\x64\\Debug\\test_two_screen_2.exe",  
        NULL,          // Command line
        NULL,           // Process handle not inheritable
        NULL,           // Thread handle not inheritable
        FALSE,          // Set handle inheritance to FALSE
        CREATE_NEW_CONSOLE,              // No creation flags
        NULL,           // Use parent's environment block
        NULL,           // Use parent's starting directory 
        &si,            // Pointer to STARTUPINFO structure
        &pi)           // Pointer to PROCESS_INFORMATION structure
        )
    {
        printf("CreateProcess failed (%d).\n", GetLastError());
        return;
    }

    // Wait until child process exits.
    /*WaitForSingleObject(pi.hProcess, INFINITE);*/

    // Close process and thread handles. 
    CloseHandle(pi.hProcess);
    CloseHandle(pi.hThread);
}


