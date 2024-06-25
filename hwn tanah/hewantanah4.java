import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Add this import statement
import javax.swing.Icon;
import javax.swing.JButton;

class hewantanah4 implements ActionListener {
    final hewantanah1 this$0;

    hewantanah4(final hewantanah1 var1) {
        this.this$0 = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        if (this.this$0.currPlantTile != null) {
            this.this$0.currPlantTile.setIcon((Icon) null);
            this.this$0.currPlantTile = null;
        }

        for (int i = 0; i < this.this$0.plantCount; i++) {
            int var2 = this.this$0.random.nextInt(9);
            JButton var3 = this.this$0.board[var2];
            if (this.this$0.currMoleTile != var3) {
                this.this$0.currPlantTile = var3;
                this.this$0.currPlantTile.setIcon(this.this$0.plantIcon);
            }
        }
    }
}