library(readr)
library(ggplot2)
library(corrplot)
library(plotly)
library(dplyr)
library(tidyr)

happy_2015 <- read.csv('/home/lt34507/Desktop/statistics_project/2015.csv')
names(happy_2015)

box <- ggplot(happy_2015, aes(x = Region, y = Happiness.Score, color = Region)) +
  geom_boxplot() +
  geom_jitter(aes(color=Country), size = 0.5) +
  ggtitle("Happiness Score for Regions and Countries") +
  coord_flip() +
  theme(legend.position="none")
ggplotly(box)


avg_happiness_region <-happy_2015 %>%
  group_by(Region) %>%
  summarise(avg_happiness = mean(Happiness.Score, round(1)))


p_avg_happiness_region <- plot_ly(avg_happiness_region, x = ~Region,
                                  y = ~avg_happiness,
                                  type = 'bar',
                                  name = 'Average Happiness',
                                  marker = list(color = 'rgb(158,202,225)')) %>%
  add_lines(y = ~mean(happy_2015$Happiness.Score), name = 'world average')%>%
  layout(title="Average Happiness per Region in 2015", yaxis = list(title = "avg. happiness score"))
ggplotly(p_avg_happiness_region)

num_hap <- happy_2015[, c("Happiness.Rank", "Happiness.Score", "Standard.Error", "Economy", "Family", "Health", "Freedom", "Trust", "Generosity", "Dystopia.Residual")]
m <- cor(num_hap)
corrplot(m, method="circle", type='upper', tl.cex=0.8, tl.col = 'black')

ggplot(happy_2015, aes(x=happy_2015$Economy, y=happy_2015$Happiness.Score))+
   geom_point(aes(color = happy_2015$Region)) +
   geom_smooth(method="lm") +
   xlab("GDP per Capita") +
   ylab("Happiness Score") +
   labs(colour="Region") +
   ggtitle("All Regions: Happiness Score & GDP per Capita (2015)")

ggplot(happy_2015, aes(x=happy_2015$Family, y=happy_2015$Happiness.Score))+ geom_point(aes(color=happy_2015$Region)) +
geom_smooth(method="lm") +
  xlab("Family") +
  ylab("Happiness Score") +
  labs(colour="Region")+
  ggtitle("All Regions: Happiness Score & Family (2015)")+
  theme(text = element_text(size=10))

ggplot(happy_2015, aes(x=happy_2015$Health, y=happy_2015$Happiness.Score))+ geom_point(aes(color = happy_2015$Region)) +
geom_smooth(method="lm") +
  xlab("Life Expectancy") +
  ylab("Happiness Score") +
  labs(colour="Region")+
  ggtitle("All Regions: Happiness Score & Life Expectancy (2015)")

