package menus;

import java.awt.*;
import java.awt.event.*;
 

 
public class Pizza extends Frame implements ItemListener,ActionListener{
	
	Label lblFoodCart,lblSize,lblToppings,lblYourOrder,lblPizzaDetails,lbl_pizatype;
	Checkbox rdbtnSmall,rdbtnMedium,rdbtnLarge,chckbxBlackOlives,chckbxMushroom,chckbxSpinach,chckbxBbq;
	CheckboxGroup cg;
	Button button_ProcessSelection;
	
	static double total;
	static String pizzaType;
	double base_total=0.0;
	double black_oilve=0,mushroom=0,spinach=0,bbq=0;
	
	Pizza()
	{
		this.setTitle("Pizza Cart");
		this.setBackground(Color.ORANGE);
		this.setSize(400, 520);
		this.setVisible(true);
		this.setLayout(null);
		this.addWindowListener(new MyListnerAdp());
                 
		

		lblFoodCart = new Label("Pizza Cart");
		lblFoodCart.setFont(new Font("Verdana", Font.BOLD, 24));
		lblFoodCart.setBounds(126, 30, 136, 52);
		
		this.add(lblFoodCart);
		
		lblSize = new Label("Taille");
		lblSize.setFont(new Font("Serif", Font.BOLD, 24));
		lblSize.setForeground(Color.BLACK);
		lblSize.setBounds(32, 79, 100, 40);
		
		this.add(lblSize);
		
		cg=new CheckboxGroup();
		
	    rdbtnSmall=new Checkbox("Small", cg, false);
		rdbtnSmall.setBackground(Color.ORANGE);
		rdbtnSmall.setBounds(32, 129, 68, 25);
		rdbtnSmall.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rdbtnMedium=new Checkbox("Medium", cg, false);
		rdbtnMedium.setBackground(Color.ORANGE);
		rdbtnMedium.setBounds(32, 154, 73, 25);
		rdbtnMedium.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rdbtnLarge=new Checkbox("Large", cg, false);
		rdbtnLarge.setBackground(Color.ORANGE);
		rdbtnLarge.setBounds(32, 184, 68, 25);
		rdbtnLarge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rdbtnSmall.addItemListener(this);
		rdbtnMedium.addItemListener(this);
		rdbtnLarge.addItemListener(this);
		
		this.add(rdbtnSmall);
		this.add(rdbtnMedium);
		this.add(rdbtnLarge);
		
	    lblToppings = new Label("Ingrédients");
		lblToppings.setFont(new Font("Serif", Font.BOLD, 24));
		lblToppings.setForeground(Color.BLACK);
		lblToppings.setBounds(151, 83, 250, 32);
		this.add(lblToppings);
		
		chckbxBlackOlives = new Checkbox("Black Olives");
		chckbxBlackOlives.setBackground(Color.ORANGE);
		chckbxBlackOlives.setBounds(151, 129, 100, 25);
		
		chckbxMushroom = new Checkbox("Mushroom");
		chckbxMushroom.setBackground(Color.ORANGE);
		chckbxMushroom.setBounds(151, 154, 100, 25);
		
		chckbxSpinach = new Checkbox("Spinach");
		chckbxSpinach.setBackground(Color.ORANGE);
		chckbxSpinach.setBounds(151, 184, 100, 25);
		
		chckbxBbq = new Checkbox("BBQ");
		chckbxBbq.setBackground(Color.ORANGE);
		chckbxBbq.setBounds(151, 214, 100, 25);
		
		chckbxBlackOlives.addItemListener(this);
		chckbxMushroom.addItemListener(this);
		chckbxSpinach.addItemListener(this);
		chckbxBbq.addItemListener(this);
		
		this.add(chckbxBlackOlives);
		this.add(chckbxMushroom);
		this.add(chckbxSpinach);
		this.add(chckbxBbq);
		
		button_ProcessSelection = new Button("Process Selection");
		button_ProcessSelection.setBackground(Color.GREEN);
		button_ProcessSelection.setForeground(Color.BLACK);
		button_ProcessSelection.setFont(new Font("Ebrima", Font.PLAIN, 21));
		button_ProcessSelection.setBounds(82, 284, 203, 45);
		
		button_ProcessSelection.addActionListener(this);
		
		this.add(button_ProcessSelection);
		
		lblYourOrder = new Label();
		lblYourOrder.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblYourOrder.setBounds(12, 356, 288, 32);
		
		lbl_pizatype=new Label();
		lbl_pizatype.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		lbl_pizatype.setBounds(12, 384, 285, 45);
		
		lblPizzaDetails = new Label();
		lblPizzaDetails.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		lblPizzaDetails.setBounds(12, 392, 285, 85);
		
		
		
		this.add(lblYourOrder);
		this.add(lbl_pizatype);
		this.add(lblPizzaDetails);
		
		
	}

	public static void main(String[] args) {
		
		new Pizza();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==button_ProcessSelection)
		{
			if(total==0)
			{
				lblYourOrder.setText("Vous n'avez pas encore fait de choix.");
			}
			else
			{
				lblYourOrder.setText("Le détail de votre commande "+" "+"....................");
				lbl_pizatype.setText("Votre Pizza est de Type : "+pizzaType);
				lblPizzaDetails.setText("Le total de votre commande est : "+String.valueOf(total)+" $");
			}
			
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		

		if(rdbtnSmall.getState()==true)
		{
			base_total=5.0;
			pizzaType="Small";
		}
		if(rdbtnMedium.getState()==true)
		{
			base_total=7.5;
			pizzaType="Medium";
		}
		if(rdbtnLarge.getState()==true)
		{
			base_total=10.0;
			pizzaType="Large";
		}
		
		if(chckbxBlackOlives.getState()==true)
		{
			black_oilve=1.5;
		}
		
		if(chckbxMushroom.getState()==true)
		{
			mushroom=1.5;
		}
		if(chckbxSpinach.getState()==true)
		{
			spinach=1.5;
		}
		if(chckbxBbq.getState()==true)
		{
			bbq=1.5;
		}
		if(chckbxBlackOlives.getState()==false)
		{
			black_oilve=0;
		}
		if(chckbxMushroom.getState()==false)
		{
			mushroom=0;
		}
		if(chckbxSpinach.getState()==false)
		{
			spinach=0;
		}
		if(chckbxBbq.getState()==false)
		{
			bbq=0;
		}
		total=base_total+black_oilve+mushroom+spinach+bbq;
		//System.out.println(total);
	}

    private void setDefautCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

