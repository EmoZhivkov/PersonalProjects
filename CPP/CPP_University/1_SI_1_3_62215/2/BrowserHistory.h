#ifndef BROWSERHISTORY_BROWSERHISTORY_H
#define BROWSERHISTORY_BROWSERHISTORY_H

const struct HistoryEntry {
    int date;
    char *url = new char[100];
};

class BrowserHistory {
private:
    int counter = -1;
    int numberOfSites;
    HistoryEntry *sites;
public:
    //Helper methods, that we only need to execute the final method properly
    int getCounter() const;
    int getNumberOfSites() const;
    HistoryEntry* getSites() const;

    BrowserHistory(int numberOfSites);
    BrowserHistory(BrowserHistory const& other);
    BrowserHistory& operator=(BrowserHistory const&);
    ~BrowserHistory();
    void addSite();
    void addSite(const HistoryEntry& current);
    void printHistory();
    int sitesVisitedOnACertainDate(int date);
    void highestTrafficMonth();
    void removeTheLastAddedSite();
    BrowserHistory* concatanateTwoBrowserHistories(BrowserHistory *first, BrowserHistory *second);
};


#endif //BROWSERHISTORY_BROWSERHISTORY_H
