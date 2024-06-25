import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class hewantanah2 implements ActionListener {
    final hewantanah1 this$0;

    hewantanah2(final hewantanah1 var1) {
        this.this$0 = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        JButton var2 = (JButton) var1.getSource();
        if (var2 == this.this$0.currMoleTile) {
            this.this$0.score += 10;
            this.this$0.textLabel.setText("Score: " + this.this$0.score);
            this.this$0.updateSpeedAndCounts();
        } else if (var2 == this.this$0.currPlantTile) {
            this.this$0.textLabel.setText("Game Over: " + this.this$0.score);
            this.this$0.setMoleTimer.stop();
            this.this$0.setPlantTimer.stop();
            for (int i = 0; i < 9; i++) {
                this.this$0.board[i].setEnabled(false);
            }
        }
    }
}