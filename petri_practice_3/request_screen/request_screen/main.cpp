#include <windows.h>
#include <stdio.h>
#include <tchar.h>
#include <iostream>
#include <chrono>
#include <thread>

#include "request.h"

void start_reqs_screen();

int main(void) {

    start_reqs_screen();
    std::vector<Request> requests = Request::get_requests();

    const char* path = "../../curr_reqs.csv";
    std::ofstream file(path);

    for(auto& request : requests)
    {
        std::chrono::seconds dura(gen_rand_num(5,15));
        std::this_thread::sleep_for(dura);
        std::cout << request << '\n';
        write_to_csv(request, file);
    }
    file.close();

    /*file.open("test.txt", std::ofstream::out | std::ofstream::trunc);
    file.close();*/

    return 0;
}

void start_reqs_screen() {

    STARTUPINFO si;
    PROCESS_INFORMATION pi;

    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));
    std::cout << "testing";
    // Start the child process. 
    if (!CreateProcess(L"C:\\mystaff\\uni\\OSHI\\_NaUKMA_oshi_practices\\petri_practice_3\\air_traffic_controller\\x64\\Release\\air_traffic_controller.exe",   // No module name (use command line)
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


