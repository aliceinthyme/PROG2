import java.awt.*;

import java.awt.event.*;
import java.util.Random;

public class drawing extends Frame {
    private DrawFrame drawFrame;
    private CheckboxGroup shapeGroup;

    public drawing() {
        setTitle("Shape Drawing Application");
        setSize(300, 200);
        setLayout(new FlowLayout());

        Button drawButton = new Button("Draw");
        Button clearButton = new Button("Clear");
        Button exitButton = new Button("Exit");
        shapeGroup = new CheckboxGroup();
        Checkbox circleRadio = new Checkbox("Circle",shapeGroup, true);
        Checkbox squareRadio = new Checkbox("Square",shapeGroup,false);
        Checkbox randomRadio = new Checkbox("Random",shapeGroup,false);
        Checkbox setSize = new Checkbox("setSizeAndCor");
        Checkbox fillCheckbox = new Checkbox("Fill");
        TextField corX = new TextField("x-coordinate");
        TextField corY = new TextField("y-coordinate");
        TextField size = new TextField("Size");
        
        Choice t = new Choice();
        
        t.add("Black");
        t.add("Blue");
        t.add("cyan");
        t.add(Color.darkGray.toString());
        t.add(Color.gray.toString());
        t.add(Color.green.toString());
        t.add(Color.lightGray.toString());
        t.add(Color.magenta.toString());
        t.add(Color.orange.toString());
        t.add(Color.pink.toString());
        t.add(Color.red.toString());
        t.add(Color.white.toString());
        t.add(Color.yellow.toString());
        drawButton.addActionListener(e -> {
            if (drawFrame == null) {
                drawFrame = new DrawFrame();
            }
            try {
            	

		            if(randomRadio.getState()) {
		            	if(!setSize.getState()) {
		            		drawFrame.drawRandomShape();
		            	}
		            	else {
		                	int sizeD = Integer.parseInt(size.getText());
		            		int corXD = Integer.parseInt(corX.getText());
		            		int corYD = Integer.parseInt(corY.getText());
		            		drawFrame.drawRandomShape(sizeD,corXD,corYD);
		            	}
		            }
		            else {
		            	if(!setSize.getState()) {
		            	drawFrame.selectedShape(circleRadio.getState(),fillCheckbox.getState());
		            	}
		            	else {
		                	int sizeD = Integer.parseInt(size.getText());
		            		int corXD = Integer.parseInt(corX.getText());
		            		int corYD = Integer.parseInt(corY.getText());
		            		drawFrame.selectedShape(sizeD,corXD,corYD,circleRadio.getState(),fillCheckbox.getState());
		            	}
		            }
	            }
            catch(Exception ex){
            	
            }
        });

        clearButton.addActionListener(e -> {
            if (drawFrame != null) {
                drawFrame.clearDrawing();
            }
        });

        exitButton.addActionListener(e -> {
            if (drawFrame != null) {
                drawFrame.dispose();
            }
            dispose();
            System.exit(0);
        });
        
        add(drawButton);
        add(clearButton);
        add(exitButton);
        add(circleRadio);
        add(squareRadio);
        add(randomRadio);
        add(fillCheckbox);
        add(size);
        add(corX);
        add(corY);
        add(setSize);
        add(t);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        drawing mainFrame = new drawing();
        mainFrame.setVisible(true);
    }
}

class DrawFrame extends Frame {
    //private Shape currentShape;

    public DrawFrame() {
        setTitle("Drawing Area");
        setSize(400, 400);
        setBackground(Color.WHITE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
    public void selectedShape(boolean circle, boolean filled) {
    	Graphics g = getGraphics();
    	Random rand = new Random();
    	int x = rand.nextInt(getWidth()-100);
    	int y = rand.nextInt(getWidth()-100);
    	int size = rand.nextInt(50)+20;
    	Color randColor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
    	g.setColor(randColor);
    	if(circle) {
    		if(filled) {
    			g.fillOval(x, y, size, size);
    		}
    		else {
    			g.drawOval(x, y, size, size);
    		}
    	}
    	else {
    		if(filled) {
    			g.fillRect(x, y, size, size);
    		}
    		else {
    			g.drawRect(x, y, size, size);
    		}
    	}
    }
    public void selectedShape(int size, int x, int y,boolean circle, boolean filled) {
    	Graphics g = getGraphics();
    	Random rand = new Random();

    	Color randColor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
    	g.setColor(randColor);
    	if(circle) {
    		if(filled) {
    			g.fillOval(x, y, size, size);
    		}
    		else {
    			g.drawOval(x, y, size, size);
    		}
    	}
    	else {
    		if(filled) {
    			g.fillRect(x, y, size, size);
    		}
    		else {
    			g.drawRect(x, y, size, size);
    		}
    	}
    }
    public void drawRandomShape() {
        Graphics g = getGraphics();
        Random rand = new Random();
        // Randomize shape type
        boolean isCircle = rand.nextBoolean();

        // Randomize position and size
        int x = rand.nextInt(getWidth() - 100);
        int y = rand.nextInt(getHeight() - 100);
        int size = rand.nextInt(50) + 20;

        // Randomize color
        Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        g.setColor(randomColor);

        // Randomize fill mode
        boolean isFilled = rand.nextBoolean();

        // Draw shape
        if (isCircle) {
            if (isFilled) {
                g.fillOval(x, y, size, size);
            } else {
                g.drawOval(x, y, size, size);
            }
        } else {
            if (isFilled) {
                g.fillRect(x, y, size, size);
            } else {
                g.drawRect(x, y, size, size);
            }
        }
    }
    public void drawRandomShape(int size, int x, int y) {
        Graphics g = getGraphics();
        Random rand = new Random();
        // Randomize shape type
        boolean isCircle = rand.nextBoolean();



        // Randomize color
        Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        g.setColor(randomColor);

        // Randomize fill mode
        boolean isFilled = rand.nextBoolean();

        // Draw shape
        if (isCircle) {
            if (isFilled) {
                g.fillOval(x, y, size, size);
            } else {
                g.drawOval(x, y, size, size);
            }
        } else {
            if (isFilled) {
                g.fillRect(x, y, size, size);
            } else {
                g.drawRect(x, y, size, size);
            }
        }
    }
    public void clearDrawing() {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
