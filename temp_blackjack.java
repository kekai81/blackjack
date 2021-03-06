package Blackjack

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Blackjack extends JFrame implements ActionListener 
{
    private int decksAmount;
    private int betAmount;
    private double playerWinnings;
    private boolean restarted = false;
    
    public String[] betList = new String[]{ "$5", "$10", "$15", "$20", "$25", "$30" , "$35", "$40", "$45", "$50" };
    
    public String[] decksList = new String[]{ "1", "2", "3", "4", "5", "6" };
    
    private Deck deck;
    public Player player = new Player("player");
    public Player dealer = new Player("dealer");

    private JButton hitButton = new JButton("Hit");
    private JButton stayButton = new JButton("Stay");
    private JButton dealButton = new JButton("Deal");
    private JButton splitButton = new JButton("Split");
    private JButton newGameButton = new JButton("New Game");
    private JButton exitButton = new JButton("Exit");
    
    private JComboBox<String> betButton = new JComboBox<String>(betList);
    private JComboBox<String> decksButton = new JComboBox<String>(decksList);
    private JLabel betLabel = new JLabel("Please Select a Bet Amount To Place");
    private JLabel decksLabel = new JLabel("Please Select The number Of Decks you would like to Use");
    
    private JLabel winStatus = new JLabel(" ");
    private JLabel playerHand = new JLabel(" ");
    private JLabel dealerHand = new JLabel(" ");
    private JLabel playerLabel = new JLabel("Player:");
    private JLabel playerBet = new JLabel("Player Bet:");
    private JLabel dealerLabel = new JLabel("Dealer:");
    private JLabel betResult = new JLabel(" ");

    JPanel playerPanel = new JPanel();
    JPanel dealerPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JPanel statusPanel = new JPanel();
    JPanel betPanel = new JPanel();
    JPanel decksPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    JFrame tableFrame = new JFrame("BlackJack");
    JFrame startFrame = new JFrame("BlackJack");
    
    public Blackjack()
    {
        getContentPane().removeAll();
        startFrame();
    }
    private void restart()
    {
        restarted = true;
        playerPanel.removeAll();
        dealerPanel.removeAll();
        playerBet.setText(" ");
        playerHand.setText(" ");
        dealerHand.setText(" ");
        winStatus.setText(" ");
        betResult.setText(" ");
        startFrame();
    }   
    private void startFrame()
    {
        startFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("cards/10.png"));
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        betPanel.setLayout(new BoxLayout(betPanel, BoxLayout.PAGE_AXIS));
        betPanel.add(Box.createVerticalGlue());
        betPanel.add(betLabel);
        betPanel.add(betButton);
        
        decksPanel.setLayout(new BoxLayout(decksPanel, BoxLayout.PAGE_AXIS));
        decksPanel.add(Box.createVerticalGlue());
        decksPanel.add(decksLabel);
        decksPanel.add(decksButton);
        
        betButton.addActionListener(this);
        decksButton.addActionListener(this);

        betButton.setEnabled(true);
        decksButton.setEnabled(true);
        
        startFrame.setLayout(new BorderLayout());
        startFrame.add(betPanel, BorderLayout.NORTH);
        startFrame.add(decksPanel, BorderLayout.SOUTH);
        startFrame.repaint();
        startFrame.setSize(300, 150);
        startFrame.setVisible(true);
    }
    private void startGame()
    {
        JFrame tableFrame = new JFrame("BlackJack");
        tableFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("cards/10.png"));
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        startFrame.dispose();
        
        buttonsPanel.add(hitButton);
        buttonsPanel.add(stayButton);
        buttonsPanel.add(dealButton);
        buttonsPanel.add(splitButton);
        
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.PAGE_AXIS));
        statusPanel.add(Box.createVerticalGlue());
        resultPanel.add(winStatus);
        statusPanel.add(playerHand);
        statusPanel.add(dealerHand);
        statusPanel.add(playerBet);

        hitButton.addActionListener(this);
        stayButton.addActionListener(this);
        dealButton.addActionListener(this);
        splitButton.addActionListener(this);

        hitButton.setEnabled(false);
        stayButton.setEnabled(false);
        dealButton.setEnabled(true);
        splitButton.addActionListener(false);

        dealerPanel.setBackground(Color.GREEN);
        
        playerPanel.setBackground(Color.GREEN);
        
        buttonsPanel.setBackground(Color.GREEN);
        statusPanel.setBackground(Color.GREEN);
        resultPanel.setBackground(Color.GREEN);

        tableFrame.setLayout(new BorderLayout());
        tableFrame.add(dealerPanel, BorderLayout.NORTH);
        tableFrame.add(playerPanel, BorderLayout.CENTER);
        tableFrame.add(buttonsPanel, BorderLayout.SOUTH);
        tableFrame.add(resultPanel, BorderLayout.EAST);
        tableFrame.add(statusPanel, BorderLayout.WEST);
        tableFrame.repaint();
        tableFrame.setSize(600, 600);
        tableFrame.setVisible(true);
    }
    private void hitPlayer() 
    {
        Card newCard = player.dealTo(deck.dealFrom());
        playerPanel.add(new JLabel(new ImageIcon("cards/" + newCard.toString())));
        playerPanel.updateUI();
    }

    private void hitDealerDown() 
    {
        Card newCard = dealer.dealTo(deck.dealFrom());
        dealerPanel.add(new JLabel(new ImageIcon("cards/b2fv.png")));
        dealerPanel.updateUI();
    }

    private void hitDealer() 
    {
        Card newCard = dealer.dealTo(deck.dealFrom());
        dealerPanel.add(new JLabel(new ImageIcon("cards/" + newCard.toString())));
        dealerPanel.updateUI();
    }
    
    private void split()
    {
    	Card cardLeft = cards.get(0);
    	handValues.clear();
    	if (cardLeft.isAce())
    	{
    		handValues.add(1);
    		handValues.add(11);
    		highValidValue = 11;
    	}
    	else
    	{
    		int cardValue = cardLeft.getValue();
    		handValues.add(cardValue);
    		highValidValue = cardValue;
    	}
    	Card splitCard = cards.remove(1);
    	playerPanel.updateUI();
    }

    private void deal() 
    {
        playerPanel.removeAll();
        dealerPanel.removeAll();
        playerPanel.updateUI();
        dealerPanel.updateUI();
        player.reset();
        dealer.reset();
        dealerPanel.add(dealerLabel);
        playerPanel.add(playerLabel);
        if (deck == null || deck.size() < 15) 
        {
          deck = new Deck(decksAmount);
          deck.shuffle();
          winStatus.setText("Shuffling");
        }
        hitPlayer();
        hitDealerDown();
        hitPlayer();
        hitDealer();
        playerHand.setText("Player Hand: " + player.value());
    }

    private void checkWinner() 
    {
        dealerPanel.removeAll();
        dealerPanel.add(dealerLabel);
        for (int i = 0; i < dealer.inHand(); i++) 
        {
            dealerPanel.add(new JLabel(new ImageIcon("cards/" + dealer.cards[i].toString())));
        }
        if (player.value() > 21) 
        {
            winStatus.setText("Player Busts");
            dealerHand.setText("Dealer Hand: " + dealer.value());
            playerHand.setText("Player Hand: " + player.value());
            winStatus.setText("Player Busts");
            playerWinnings = 0;
        } else if (dealer.value() > 21) 
        {
            winStatus.setText("Dealer Busts");
            dealerHand.setText("Dealer Hand: " + dealer.value());
            playerHand.setText("Player Hand: " + player.value());
            playerWinnings = betAmount*2;
        } else if (dealer.value() == player.value()) 
        {
            winStatus.setText("Push");
            dealerHand.setText("Dealer Hand: " + dealer.value());
            playerHand.setText("Player Hand: " + player.value());
            playerWinnings = betAmount;
        } else if ((dealer.value() != player.value()) && (player.inHand() == 2 && player.value() ==21)) 
        {
            winStatus.setText("Natural Blackjack - Player Wins");
            dealerHand.setText("Dealer Hand: " + dealer.value());
            playerHand.setText("Player Hand: " + player.value());
            playerWinnings = betAmount*2.5;
        } else if (dealer.value() < player.value()) 
        {
            winStatus.setText("Player Wins");
            dealerHand.setText("Dealer Hand: " + dealer.value());
            playerHand.setText("Player Hand: " + player.value());
            playerWinnings = betAmount*2;
        } else 
        {
            winStatus.setText("Dealer Wins");
            dealerHand.setText("Dealer Hand: " + dealer.value());
            playerHand.setText("Player Hand: " + player.value());
            playerWinnings = 0;
        }
        end();
    }
    public void end()
    {
        statusPanel.add(betResult);
        betResult.setText("Player Winnings: $" + playerWinnings);
        hitButton.setEnabled(false);
        stayButton.setEnabled(false);
        splitButton.setEnabled(false);
        dealButton.setEnabled(false);
        newGameButton.addActionListener(this);
        exitButton.addActionListener(this);
        buttonsPanel.add(newGameButton);
        buttonsPanel.add(exitButton);  
        newGameButton.setEnabled(true);
        exitButton.setEnabled(true);
        tableFrame.repaint();        
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == betButton) 
        {

            JComboBox betButton = (JComboBox)e.getSource();
            String betString = (String)betButton.getSelectedItem();
            String betSubstring = betString.substring(1, betString.length());
            betAmount = Integer.parseInt(betSubstring);
            betButton.setEnabled(false);
            playerBet.setText("Player Bet: $" + betAmount);
            if(decksButton.isEnabled() == false && restarted == false)
            {
               startGame();
            }
            if(decksButton.isEnabled() == false && restarted != false)
            {     
               startFrame.dispose();
               dealButton.setEnabled(true);
               repaint();
            }         
        }
        if (e.getSource() == decksButton) 
        {
            JComboBox decksButton = (JComboBox)e.getSource();
            decksAmount = Integer.parseInt((String)decksButton.getSelectedItem());
            decksButton.setEnabled(false);
            playerBet.setText("Player Bet: $" + betAmount);
            if(betButton.isEnabled() == false && restarted == false)
            {
               startGame();
            }
            if(betButton.isEnabled() == false && restarted != false)
            {     
               startFrame.dispose();
               dealButton.setEnabled(true);
               repaint();
            }    
        }
        if (e.getSource() == dealButton) 
        {
            deal();
            winStatus.setText(" ");
            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
            splitButton.setEnabled(true);
            dealButton.setEnabled(false);
        }
        if (e.getSource() == hitButton) 
        {
            hitPlayer();
            playerHand.setText("Player Hand: " + player.value());
            if (player.value() > 21) 
            {
                checkWinner();
                hitButton.setEnabled(false);
                stayButton.setEnabled(false);
                splitButton.setEnabled(false);
                dealButton.setEnabled(true);
            }
        }

        if (e.getSource() == stayButton) 
        {
            while (dealer.value() < 17 || player.value() > dealer.value()) 
            {
                hitDealer();
            }
            checkWinner();
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
            splitButton.setEnabled(false);
            dealButton.setEnabled(true);
        }
        if (e.getSource()== splitButton)
        {
        	
        }
        if (e.getSource() == newGameButton) 
        {
            restart();
            buttonsPanel.remove(newGameButton);
            buttonsPanel.remove(exitButton);
        }
        if (e.getSource() == exitButton) 
        {
            System.exit(0);
        }
    }

    public static void main(String args[]) 
    {
        new Blackjack();
    }
}
