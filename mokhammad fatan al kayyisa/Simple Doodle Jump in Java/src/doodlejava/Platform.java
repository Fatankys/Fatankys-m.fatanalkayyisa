package doodlejava;

import java.awt.Rectangle;
import oneiros.games.OSprite;
import util.mulaifatanalkayyisa;

public class Platform extends OSprite{

    public Platform() {
        super(mulaifatanalkayyisa.getImage("platform.png"));
    }

    public Rectangle getBase(){
        return new Rectangle(getX(), getY(), getWidth(), 2);
    }


}
