namespace CurrencyConverterForm
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.numericUpDownAmmount = new System.Windows.Forms.NumericUpDown();
            this.labelBGN = new System.Windows.Forms.Label();
            this.comboBoxCurrency = new System.Windows.Forms.ComboBox();
            this.labelResult = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownAmmount)).BeginInit();
            this.SuspendLayout();
            // 
            // numericUpDownAmmount
            // 
            this.numericUpDownAmmount.DecimalPlaces = 2;
            this.numericUpDownAmmount.Location = new System.Drawing.Point(12, 30);
            this.numericUpDownAmmount.Maximum = new decimal(new int[] {
            1000000,
            0,
            0,
            0});
            this.numericUpDownAmmount.Name = "numericUpDownAmmount";
            this.numericUpDownAmmount.Size = new System.Drawing.Size(120, 20);
            this.numericUpDownAmmount.TabIndex = 0;
            this.numericUpDownAmmount.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.numericUpDownAmmount.ValueChanged += new System.EventHandler(this.numericUpDownAmmount_ValueChanged);
            // 
            // labelBGN
            // 
            this.labelBGN.AutoSize = true;
            this.labelBGN.Location = new System.Drawing.Point(153, 33);
            this.labelBGN.Name = "labelBGN";
            this.labelBGN.Size = new System.Drawing.Size(30, 13);
            this.labelBGN.TabIndex = 1;
            this.labelBGN.Text = "BGN";
            // 
            // comboBoxCurrency
            // 
            this.comboBoxCurrency.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboBoxCurrency.FormattingEnabled = true;
            this.comboBoxCurrency.Items.AddRange(new object[] {
            "EUR",
            "USD",
            "GBP"});
            this.comboBoxCurrency.Location = new System.Drawing.Point(215, 30);
            this.comboBoxCurrency.Name = "comboBoxCurrency";
            this.comboBoxCurrency.Size = new System.Drawing.Size(121, 21);
            this.comboBoxCurrency.TabIndex = 2;
            this.comboBoxCurrency.SelectedIndexChanged += new System.EventHandler(this.comboBoxCurrency_SelectedIndexChanged);
            // 
            // labelResult
            // 
            this.labelResult.BackColor = System.Drawing.Color.LimeGreen;
            this.labelResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelResult.Location = new System.Drawing.Point(12, 77);
            this.labelResult.Name = "labelResult";
            this.labelResult.Size = new System.Drawing.Size(324, 32);
            this.labelResult.TabIndex = 3;
            this.labelResult.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(352, 137);
            this.Controls.Add(this.labelResult);
            this.Controls.Add(this.comboBoxCurrency);
            this.Controls.Add(this.labelBGN);
            this.Controls.Add(this.numericUpDownAmmount);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownAmmount)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.NumericUpDown numericUpDownAmmount;
        private System.Windows.Forms.Label labelBGN;
        private System.Windows.Forms.ComboBox comboBoxCurrency;
        private System.Windows.Forms.Label labelResult;
    }
}

