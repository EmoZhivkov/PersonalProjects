# https://www.kaggle.com/mozgul/visualization-eda-plotly-ggplot

library(readr)
library(ggplot2)
library(corrplot)

happy_2015 <- read.csv('/home/lt34507/Desktop/statistics_project/2015.csv')

# Correlogram
# Correlations: What factors have strong relationship with Happiness?
# Now we can create a correlogram to analyze the relationships. To do that we need only numeric columns. So I select the numeric columns only and create a dataframe called num_hap.
num_hap <- happy_2015[, c("Happiness.Rank", "Happiness.Score", "Standard.Error", "Economy", "Family", "Health", "Freedom", "Trust", "Generosity", "Dystopia.Residual")]
m <- cor(num_hap)
corrplot(m, method="circle", type='upper', tl.cex=0.8, tl.col = 'black')

# Heatmap: (Just another variant of displaying the correlations)
corrplot(m, method="square", type='full', tl.cex=0.8, tl.col = 'black')

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

