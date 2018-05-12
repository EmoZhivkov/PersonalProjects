using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFirst
{
    public partial class Summator : Form
    {
        public Summator()
        {
            InitializeComponent();
        }

        private void ButCalculate_Click(object sender, EventArgs e)
        {
            var first = int.Parse(this.textBox1.Text);
            var second = int.Parse(this.textBox2.Text);
            var result = (first + second);
            this.textBoxSum.Text = result.ToString();
        }
    }
}
