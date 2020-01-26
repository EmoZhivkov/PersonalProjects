
NN <- 300
set.seed(73391)
x1 <- round(runif(NN, 0, 5), 1)
x2 <- round(runif(NN, 3, 7), 1)
y <- round(runif(NN, 2, 6), 1)

# cor(x1, y)
# cor(x2, y)

model = lm(y ~ x2 + I(x2 ^ 2))

s = summary(model)

#coef(s)[,4]
t_values = coef(s)[, 3] # t value
p_values = coef(s)[, 4] # p value

# 't_values'
# for (i in t_values) {
#     print(i)
# }

# print("n")
# 'p_values'
# for (i in p_values) {
#     print(i)
# }

#s$r.squared

r = residuals(model)
y_pred = predict(model)

# lmtest::bptest(model)$p.value
# plot(y_pred, r)

#lmtest::dwtest(model)$p.value

# shapiro.test(r)
qqnorm(r)
qqline(r)






# x1_p_value = shapiro.test(x1)$p.value
# x2_p_value = shapiro.test(x2)$p.value

# if (x1_p_value > 0.05 && x2_p_value > 0.05) {
#     test_p_value = t.test(x1, x2)$p.value
#     if (test_p_value > 0.05) {
#         print('parametrite sa ravni')
#     } else {
#         print('ne sa ravni brat')
#     }
#     print("----------------")
# } else {
#     test_p_value = wilcox.test(x1, x2)$p.value
#     if (test_p_value > 0.05) {
#         print('parametrite sa ravni')
#     } else {
#         print('ne sa ravni brat')
#     }
# }


# DF = data.frame(group = c(1, 2), value = c(x1, x2))
# DF


# summary(aov(value ~ group, DF))[[1]][[1, "Pr(>F)"]]
# kruskal.test(value ~ group, DF)$p.value
