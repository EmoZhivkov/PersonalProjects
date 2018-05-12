using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CurrencyConverterForm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void comboBoxCurrency_SelectedIndexChanged(object sender, EventArgs e)
        {
            CalculateResult();
        }

        private void numericUpDownAmmount_ValueChanged(object sender, EventArgs e)
        {
            CalculateResult();
        }

        private void CalculateResult()
        {
            var targetCurrency = this.comboBoxCurrency.SelectedItem.ToString();
            var convertedAmount = targetCurrency;

            if (targetCurrency == "EUR")
    {
        convertedAmount = targetCurrency / 1.95583m;
    }
    else if (targetCurrency == "USD")
    {
        convertedAmount = targetCurrency / 1.80810m;
}
    else if (targetCurrency == "GBP")
    {
        convertedAmount = targetCurrency / 2.54990m;
    }
    this.labelResult.Text = originalAmount + " лв. = " +
        Math.Round(convertedAmount, 2) + " " + this.comboBoxCurrency.SelectedItem;
}

        }
    }
}
