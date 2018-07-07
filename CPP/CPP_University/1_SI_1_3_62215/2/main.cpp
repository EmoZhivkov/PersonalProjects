#include <iostream>
#include "BrowserHistory.h"
using namespace std;
int main() {
    BrowserHistory* chrome = new BrowserHistory(5);
    chrome->addSite();
    chrome->addSite();
    chrome->addSite();

    BrowserHistory* firefox = new BrowserHistory(3);
    firefox->addSite();
    firefox->addSite();


    HistoryEntry *test = new HistoryEntry();
    test->date = 2;
    char* url;
    url = "google.com";

    test->url = url;

    chrome->addSite(*test);

    chrome->printHistory();

    cout<<"Sites visited in March: ";
    std::cout << chrome->sitesVisitedOnACertainDate(3) << std::endl;

    chrome->highestTrafficMonth();

    chrome->removeTheLastAddedSite();

    chrome->printHistory();

    std::cout << std::endl;

    BrowserHistory* final = chrome->concatanateTwoBrowserHistories(chrome, firefox);

    final->printHistory();
    return 0;
}