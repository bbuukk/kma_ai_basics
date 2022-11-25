#include <windows.h>
#include <stdio.h>
#include <tchar.h>
#include <iostream>

void start_reqs_screen();

void main(void)
{
    start_reqs_screen();
}

void start_reqs_screen() {

    STARTUPINFO si;
    PROCESS_INFORMATION pi;

    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));
    std::cout << "testing";
    // Start the child process. 
    if (!CreateProcess(L"C:\\mystaff\\uni\\OSHI\\_NaUKMA_oshi_practices\\petri_practice_3\\request_screen\\x64\\Release\\request_screen.exe",   // No module name (use command line)
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

