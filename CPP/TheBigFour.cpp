HistoryEntry::HistoryEntry() 
{
	this->date = 0;
	this->URL = nullptr;
}

HistoryEntry::~HistoryEntry() 
{
	delete[] URL;
}

HistoryEntry::HistoryEntry(const HistoryEntry &other) 
{
	this->date = other.date;
	this->URL = nullptr;
	setURL(other.URL);
}

HistoryEntry& HistoryEntry::operator = (const HistoryEntry &other)
{
	if (this != &other)
	{
		delete[] URL;
		this->date = other.date;
		setURL(other.URL);
	}
	return *this;
}