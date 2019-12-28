# https://www.kaggle.com/mozgul/visualization-eda-plotly-ggplot

library(readr)
library(ggplot2)
library(corrplot)
library(plotly)
library(dplyr)
library(tidyr)

happy_2015 <- read.csv('/home/lt34507/Desktop/statistics_project/2015.csv')
names(happy_2015)

# Box Plot
# Since happiness rank is based on happiness score, I would like to analyze the average happiness score among
# regions and then try to focus on the characteristics of the happiest and unhappiest regions.
box <- ggplot(happy_2015, aes(x = Region, y = Happiness.Score, color = Region)) +
  geom_boxplot() +
  geom_jitter(aes(color=Country), size = 0.5) +
  ggtitle("Happiness Score for Regions and Countries") +
  coord_flip() +
  theme(legend.position="none")
ggplotly(box)

# Histogram -> average happiness per region
avg_happiness_region <-happy_2015 %>%
  group_by(Region) %>%
  summarise(avg_happiness = mean(Happiness.Score, round(1)))

# Plotting the average happiness scores to compare regions
p_avg_happiness_region <- plot_ly(avg_happiness_region, x = ~Region,
                                  y = ~avg_happiness,
                                  type = 'bar',
                                  name = 'Average Happiness',
                                  marker = list(color = 'rgb(158,202,225)')) %>%
  add_lines(y = ~mean(happy_2015$Happiness.Score), name = 'world average')%>%
  layout(title="Average Happiness per Region in 2015", yaxis = list(title = "avg. happiness score"))
ggplotly(p_avg_happiness_region)

# Top 3 happiest regions based on average happiness score are: -Australia & New Zealand -North America -Western Europe
# It is important to note that both of the first two regions include only 2 countries and Western Europe has 21 countries.
# Additionally all of these regions include countries with developed economies.

# The unhappiest region is Sub-Saharan Africa, which includes 40 different countries. The second unhappiest region is Southern Asia.


# Correlation matrix
# Correlations: What factors have strong relationship with Happiness?
# Now we can create a correlogram to analyze the relationships. To do that we need only numeric columns. So I select the numeric columns only and create a dataframe called num_hap.
num_hap <- happy_2015[, c("Happiness.Rank", "Happiness.Score", "Standard.Error", "Economy", "Family", "Health", "Freedom", "Trust", "Generosity", "Dystopia.Residual")]
m <- cor(num_hap)
corrplot(m, method="circle", type='upper', tl.cex=0.8, tl.col = 'black')

# Strong correlations will give me an idea about which attributes were more related to happiness score.
# Now I will plot the top three strongly correlated attributes with happiness score:

# Happiness Score and GDP per Capita on all regions
# Countries that have higher gdp per capita seems to be happier.
# Since higher gdp per capita indicates a better standard of living for a country, it makes sense.
ggplot(happy_2015, aes(x=happy_2015$Economy, y=happy_2015$Happiness.Score))+
   geom_point(aes(color = happy_2015$Region)) +
   geom_smooth(method="lm") +
   xlab("GDP per Capita") +
   ylab("Happiness Score") +
   labs(colour="Region") +
   ggtitle("All Regions: Happiness Score & GDP per Capita (2015)")

# Happiness Score and Family
# Although the explanation family attribute is not clear in the metadata, family contributes to happier people.
ggplot(happy_2015, aes(x=happy_2015$Family, y=happy_2015$Happiness.Score))+ geom_point(aes(color=happy_2015$Region)) +
geom_smooth(method="lm") +
  xlab("Family") +
  ylab("Happiness Score") +
  labs(colour="Region")+
  ggtitle("All Regions: Happiness Score & Family (2015)")+
  theme(text = element_text(size=10))

# Happiness Score and Life Expectancy
# Life expectancy, probably the average years of life contributes to happier positively.
ggplot(happy_2015, aes(x=happy_2015$Health, y=happy_2015$Happiness.Score))+ geom_point(aes(color = happy_2015$Region)) +
geom_smooth(method="lm") +
  xlab("Life Expectancy") +
  ylab("Happiness Score") +
  labs(colour="Region")+
  ggtitle("All Regions: Happiness Score & Life Expectancy (2015)")

