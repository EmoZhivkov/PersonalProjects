#include "BrowserHistory.h"
#include <iostream>

BrowserHistory::BrowserHistory(int numberOfSites) {
    this->numberOfSites = numberOfSites;
    this->sites = new HistoryEntry[numberOfSites];
}

BrowserHistory::BrowserHistory(BrowserHistory const &other) {
    this->numberOfSites = other.getNumberOfSites();
    this->sites = other.getSites();
}

BrowserHistory &BrowserHistory::operator=(BrowserHistory const& other) {
    if (this != &other) {
        this->counter = other.getCounter();
        this->numberOfSites = other.getNumberOfSites();
        this->sites = other.getSites();
    }
    return *this;
}

BrowserHistory::~BrowserHistory() {
    delete[] this->sites;
}

int BrowserHistory::getCounter() const{
    return this->counter;
}

int BrowserHistory::getNumberOfSites() const{
    return this->numberOfSites;
}

HistoryEntry* BrowserHistory::getSites() const{
    return this->sites;
}

void BrowserHistory::addSite() {
    if (counter == numberOfSites){
        std::cout<<"Error! The Browser ran out of memory"<<std::endl;
        return;
    }

    int date;
    std::cout << "Enter Date: ";
    std::cin >> date;

    char *url = new char[100];
    std::cout<< "Enter URL: ";
    std::cin >> url;

    HistoryEntry *current = new HistoryEntry();
    current->date = date;
    current->url = url;


    this->counter++;
    this->sites[counter] = *current;
}

void BrowserHistory::addSite(const HistoryEntry& current) {
    if (counter == numberOfSites){
        std::cout<<"Error! The Browser ran out of memory"<<std::endl;
        return;
    }

    this->counter++;
    this->sites[counter] = current;
}

void BrowserHistory::printHistory() {
    for (int i = 0; i <= this->counter; i++) {
        std::cout<< "Date: "<<this->sites[i].date<<"; ";
        std::cout<< "URL: "<< this->sites[i].url << std::endl;
        std::cout<< ">>>>>>>>>>>>>>>>>>>>>>>>" << std::endl;
    }
}

int BrowserHistory::sitesVisitedOnACertainDate(int date) {
    int cnt = 0;
    for (int i = 0; i <= this->counter; ++i) {
        if (this->sites[i].date == date) {
            cnt++;
        }
    }
    return cnt;
}

void BrowserHistory::highestTrafficMonth() {
    int highestTrafficMonth = 0;
    int h = 0;

    for (int i = 1; i <= 12; i++) {
        h = this->sitesVisitedOnACertainDate(i);
        if (h > highestTrafficMonth) {
            highestTrafficMonth = h;
        }
    }

    std::cout<<"The Month with the highest traffic is: "<< highestTrafficMonth<< std::endl;
}

void BrowserHistory::removeTheLastAddedSite() {
    this->counter--;
}

BrowserHistory* BrowserHistory::concatanateTwoBrowserHistories(BrowserHistory *first, BrowserHistory *second) {
    int actualNumberOfSites =first->getCounter() + second->getCounter();
    int *arr = new int[actualNumberOfSites];

    int theWholeSpaceThatTheTwoHistoriesHave = first->getNumberOfSites() + second->getNumberOfSites();
    BrowserHistory* concatenation = new BrowserHistory(theWholeSpaceThatTheTwoHistoriesHave);

    HistoryEntry* firstBrowser = first->getSites();
    HistoryEntry* secondBrowser = second->getSites();

    for (int i = 0; i <= first->getCounter(); i++) {
        concatenation->addSite(firstBrowser[i]);
    }
    for (int i = 0; i <= second->getCounter(); i++) {
        concatenation->addSite(secondBrowser[i]);
    }

    return concatenation;
}











