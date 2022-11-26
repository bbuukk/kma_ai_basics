#include <windows.h>
#include <stdio.h>
#include <tchar.h>
#include <iostream>
#include <fstream>
#include <chrono>
#include <thread>
#include <string>

int main(void)
{   
    std::cout << "Part 2\n";
    std::string myText;
    std::string filepath("C:\\mystaff\\uni\\moop\\foo.txt");
    std::ifstream ifs(filepath);
   
    if (ifs.is_open())
    {
        std::string line;
        while (true)
        {
            while (std::getline(ifs, line)) std::cout << line << "\n";
            if (!ifs.eof()) break; // ensure end of read was EOF.
            ifs.clear();

            //avoiding cpu hogging
            std::this_thread::sleep_for(std::chrono::milliseconds(10));
        }
    }

    ifs.close();

    system("pause");

    return 0;
}


