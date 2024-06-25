import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;

class hewantanah3 implements ActionListener {
    final hewantanah1 this$0;

    hewantanah3(final hewantanah1 var1) {
        this.this$0 = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        if (this.this$0.currMoleTile != null) {
            this.this$0.currMoleTile.setIcon((Icon) null);
            this.this$0.currMoleTile = null;
        }

        int var2 = this.this$0.random.nextInt(9);
        JButton var3 = this.this$0.board[var2];
        if (this.this$0.currPlantTile != var3) {
            this.this$0.currMoleTile = var3;
            this.this$0.currMoleTile.setIcon(this.this$0.moleIcon);
        }
    }
}