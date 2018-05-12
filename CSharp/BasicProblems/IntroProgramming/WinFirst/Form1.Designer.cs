namespace WinFirst
{
    partial class Summator
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
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.Plus = new System.Windows.Forms.Label();
            this.Equals = new System.Windows.Forms.Label();
            this.textBoxSum = new System.Windows.Forms.TextBox();
            this.ButCalculate = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(47, 12);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 0;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(47, 60);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 20);
            this.textBox2.TabIndex = 1;
            // 
            // Plus
            // 
            this.Plus.AutoSize = true;
            this.Plus.Location = new System.Drawing.Point(25, 39);
            this.Plus.Name = "Plus";
            this.Plus.Size = new System.Drawing.Size(13, 13);
            this.Plus.TabIndex = 2;
            this.Plus.Text = "+";
            // 
            // Equals
            // 
            this.Equals.AutoSize = true;
            this.Equals.Location = new System.Drawing.Point(25, 94);
            this.Equals.Name = "Equals";
            this.Equals.Size = new System.Drawing.Size(13, 13);
            this.Equals.TabIndex = 3;
            this.Equals.Text = "=";
            // 
            // textBoxSum
            // 
            this.textBoxSum.Location = new System.Drawing.Point(47, 116);
            this.textBoxSum.Name = "textBoxSum";
            this.textBoxSum.Size = new System.Drawing.Size(100, 20);
            this.textBoxSum.TabIndex = 4;
            // 
            // ButCalculate
            // 
            this.ButCalculate.Location = new System.Drawing.Point(47, 162);
            this.ButCalculate.Name = "ButCalculate";
            this.ButCalculate.Size = new System.Drawing.Size(100, 25);
            this.ButCalculate.TabIndex = 5;
            this.ButCalculate.Text = "Calculate";
            this.ButCalculate.UseVisualStyleBackColor = true;
            this.ButCalculate.Click += new System.EventHandler(this.ButCalculate_Click);
            // 
            // Summator
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(190, 216);
            this.Controls.Add(this.ButCalculate);
            this.Controls.Add(this.textBoxSum);
            this.Controls.Add(this.Equals);
            this.Controls.Add(this.Plus);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Name = "Summator";
            this.Text = "Summator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label Plus;
        private System.Windows.Forms.Label Equals;
        private System.Windows.Forms.TextBox textBoxSum;
        private System.Windows.Forms.Button ButCalculate;
    }
}

