package com.mihoyo.genshinpoker;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author onemotre
 */
public class GamePage extends javax.swing.JFrame {

    /**
     * Creates new form GamePage
     */
    public GamePage() {
        initParam();
        initComponentsSelf();
        // initCards();
    }

    /**
     * &#064;brief  窗体、组件大小定义，素材大小重塑
     * &#064;date  2023-12-15 23:00:00
     */
    private void initParam() {
        // 素材初始化
        this.iconTopImage = new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/com/mihoyo/genshinpoker/images/background/bottomFrame.png")));
        this.iconBackGround = new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/com/mihoyo/genshinpoker/images/background/background.jpeg")));
        this.iconCardBack = new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/com/mihoyo/genshinpoker/images/pokerCard/back.jpg")));
        this.iconButton = new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/com/mihoyo/genshinpoker/images/background/button.png")));
        this.icon = new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/com/mihoyo/genshinpoker/images/background/icon.jpg")));

        java.awt.Image imageTop;
        java.awt.Image imageBackGround;
        java.awt.Image imageCardBack;
        java.awt.Image imageButton;
        imageTop = iconTopImage.getImage();
        imageBackGround = iconBackGround.getImage();
        imageCardBack = iconCardBack.getImage();
        imageButton = iconButton.getImage();

        // 窗体、顶部图片大小
        this.sizeFrameWidth = imageBackGround.getWidth(null);
        this.sizeTopImageHeight = imageBackGround.getWidth(null) * imageTop.getHeight(null) / imageTop.getWidth(null) - 20;
        this.sizeFrameHeight = imageBackGround.getHeight(null) + imageTop.getHeight(null);

        // 主面板大小
        this.sizeMainPanelWidth = imageBackGround.getWidth(null);
        this.sizeMainPanelHeight = imageBackGround.getHeight(null);

        // 牌面大小
        this.sizeCardHeight = imageCardBack.getHeight(null) / 15;
        this.sizeCardWidth = imageCardBack.getWidth(null) / 15;

        // 玩家组件大小
        this.sizePlayerHeight = this.sizeCardHeight + 4;
        this.sizePlayerWidth = this.sizeFrameWidth;

        // 按键大小
        this.sizeButtonHeight = imageButton.getHeight(null) / 5;
        this.sizeButtonWidth = imageButton.getWidth(null) / 5;

        // 电脑组件大小
        this.sizePlayerComHeight = imageBackGround.getHeight(null) - this.sizePlayerHeight;
        this.sizePlayerComWidth = this.sizeCardWidth + 6;

        // 操作区大小
        this.sizeOperatorHeight = this.sizeButtonHeight;
        this.sizeOperatorWidth = this.sizeFrameWidth;

        // 牌池大小
        this.sizeCardPoolHeight = imageBackGround.getHeight(null) - this.sizePlayerHeight - this.sizeOperatorHeight;
        this.sizeCardPoolWidth = imageBackGround.getWidth(null) - this.sizePlayerComWidth * 2;


        //////////////////////////// 素材大小重塑 ////////////////////////////
        java.awt.Image newImage;
        // 顶部图片
        newImage = imageTop.getScaledInstance(this.sizeFrameWidth, this.sizeTopImageHeight, java.awt.Image.SCALE_SMOOTH);
        this.iconTopImage.setImage(newImage);
        // 牌背面
        newImage = imageCardBack.getScaledInstance(this.sizeCardWidth, this.sizeCardHeight, java.awt.Image.SCALE_SMOOTH);
        this.iconCardBack.setImage(newImage);
        // 按钮
        newImage = imageButton.getScaledInstance(this.sizeButtonWidth, this.sizeButtonHeight, java.awt.Image.SCALE_SMOOTH);
        this.iconButton.setImage(newImage);
    }

    private void initComponentsSelf() {
        java.awt.GridBagConstraints gridBagConstraints;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        this.setIconImage(this.icon.getImage());
        this.setTitle("GenShinPoker");

        panel_topImage = new javax.swing.JPanel();
        panel_main = new javax.swing.JPanel();
        panel_player = new javax.swing.JPanel();
        panel_playerCom1 = new javax.swing.JPanel();
        panel_playerCom2 = new javax.swing.JPanel();
        panel_cardPool = new javax.swing.JPanel();
        panel_operateArea = new javax.swing.JPanel();
        button_start = new javax.swing.JButton();
        button_out = new javax.swing.JButton();
        button_pass = new javax.swing.JButton();
        label_topImage = new javax.swing.JLabel();
        label_background = new javax.swing.JLabel();

        // 初始化panel_topImage
        panel_topImage.setLayout(new GridBagLayout());
        panel_topImage.setOpaque(false);
        // 初始化label_topImage
        label_topImage.setIcon(this.iconTopImage);
        label_topImage.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.ipady = 0;
        panel_topImage.add(label_topImage, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(panel_topImage, gridBagConstraints);

        ///////////////////////// 初始化panel_main /////////////////////////
        panel_main.setLayout(new java.awt.GridBagLayout());
        panel_main.setOpaque(false);
        panel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        // TODO: 不使用任何布局了！！！！日你妈的GridBagLayout！！！！
        // 初始化panel_playerCom1
        panel_playerCom1.setLayout(new java.awt.BorderLayout());
        panel_playerCom1.setOpaque(false);
        panel_playerCom1.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.ipadx = this.sizePlayerComWidth;
        gridBagConstraints.ipady = this.sizePlayerComHeight;
        panel_main.add(panel_playerCom1, gridBagConstraints);

        // 初始化panel_playerCom2
        panel_playerCom2.setLayout(new java.awt.BorderLayout());
        panel_playerCom2.setOpaque(false);
        panel_playerCom2.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.ipadx = this.sizePlayerComWidth;
        gridBagConstraints.ipady = this.sizePlayerComHeight;
        panel_main.add(panel_playerCom2, gridBagConstraints);



        // background picture
        label_background.setIcon(this.iconBackGround);
        label_background.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 2;
        gridBagConstraints.weighty = 2;
        panel_main.add(label_background, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.ipady = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        getContentPane().add(panel_main, gridBagConstraints);

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /* <editor-fold default-state="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents */
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_topImage = new javax.swing.JPanel();
        panel_main = new javax.swing.JPanel();
        panel_player = new javax.swing.JPanel();
        panel_playerCom1 = new javax.swing.JPanel();
        panel_playerCom2 = new javax.swing.JPanel();
        panel_cardPool = new javax.swing.JPanel();
        panel_operateArea = new javax.swing.JPanel();
        button_start = new javax.swing.JButton();
        button_out = new javax.swing.JButton();
        button_pass = new javax.swing.JButton();
        label_topImage = new javax.swing.JLabel();
        label_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        this.setIconImage(this.icon.getImage());
        this.setTitle("GenShinPoker");

        panel_topImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_topImage.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(panel_topImage, gridBagConstraints);

        panel_main.setLayout(new java.awt.GridBagLayout());
        panel_main.setOpaque(false);
        panel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        panel_player.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_player.setOpaque(false);

        JLabel test = new JLabel();
        ImageIcon icon = new ImageIcon(Card.getCardPicUrl(1));
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(this.sizeCardWidth, this.sizeCardHeight, java.awt.Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        test.setIcon(icon);
        test.setSize(this.sizeCardWidth, this.sizeCardHeight);
        test.setOpaque(false);
        panel_player.add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, this.sizeCardWidth, this.sizeCardHeight));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        panel_main.add(panel_player, new java.awt.GridBagConstraints());
        panel_player.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

        panel_playerCom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_playerCom1.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 2;
        panel_main.add(panel_playerCom1, new java.awt.GridBagConstraints());

        panel_playerCom2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_playerCom2.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 2;
        panel_main.add(panel_playerCom2, new java.awt.GridBagConstraints());

        panel_cardPool.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        // 显示panel_cardPool的边框
        panel_cardPool.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        panel_main.add(panel_cardPool, new java.awt.GridBagConstraints());

        panel_operateArea.setLayout(new java.awt.GridBagLayout());
        panel_operateArea.setOpaque(false);


        button_start.setIcon(this.iconButton);
        button_start.setText("开始游戏");
        button_start.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_start.setVerticalTextPosition(SwingConstants.CENTER);
        button_start.setBorderPainted(false);
        button_start.setContentAreaFilled(false);
        button_start.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = this.sizeFrameWidth;
        gridBagConstraints.weighty = this.sizeFrameHeight;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panel_operateArea.add(button_start, gridBagConstraints);

        button_out.setIcon(this.iconButton);
        button_out.setText("出牌");
        button_out.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_out.setVerticalTextPosition(SwingConstants.CENTER);
        button_out.setBorderPainted(false);
        button_out.setContentAreaFilled(false);
        button_out.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = this.sizeFrameWidth;
        gridBagConstraints.weighty = this.sizeFrameHeight;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panel_operateArea.add(button_out, gridBagConstraints);

        button_pass.setIcon(this.iconButton);
        button_pass.setText("不出");
        button_pass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_pass.setVerticalTextPosition(SwingConstants.CENTER);
        button_pass.setBorderPainted(false);
        button_pass.setContentAreaFilled(false);
        button_pass.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = this.sizeFrameWidth;
        gridBagConstraints.weighty = this.sizeFrameHeight;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panel_operateArea.add(button_pass, gridBagConstraints);

        // panel_operateArea 在 panel_main 中的位置
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        panel_main.add(panel_operateArea, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(panel_main, gridBagConstraints);

        label_topImage.setIcon(this.iconTopImage);
        label_topImage.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(label_topImage, gridBagConstraints);

        label_background.setIcon(this.iconBackGround);
        label_background.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(label_background, gridBagConstraints);
        pack();

        button_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("开始游戏");
                button_startActionPerformed(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * &#064;brief  初始化牌组
     * &#064;date  2023-12-17 01:00:00
     */
    private void initCards() {
        ArrayList<ArrayList<Integer>> puke = Card.licensing(3);
        ArrayList<Integer> player1 = puke.get(0);
        Card player1Card = new Card(Card.sortCards(player1));
        ArrayList<Integer> player2 = puke.get(1);
        Card player2Card = new Card(Card.sortCards(player2));
        ArrayList<Integer> player3 = puke.get(2);
        Card player3Card = new Card(Card.sortCards(player3));

        int i = 0;
        // 初始化玩家组件
        for (Integer card : player1) {
            // 根据panel_player的大小计算牌的位置
            int positionX = (this.sizePlayerWidth / player1Card.getCards().size()) * i;
            int positionY = this.sizePlayerHeight;
            JLabel label = new JLabel();
            // 牌面大小收缩
            ImageIcon icon = new ImageIcon(Card.getCardPicUrl(card));
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(this.sizeCardWidth, this.sizeCardHeight, java.awt.Image.SCALE_SMOOTH);
            icon.setImage(newImage);
            label.setIcon(icon);
            label.setSize(this.sizeCardWidth, this.sizeCardHeight);
            label.setOpaque(false);
            // 向panel_player添加牌，后面的牌可以覆盖前面的牌
            this.panel_player.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(positionX, positionY, this.sizeCardWidth, this.sizeCardHeight));
            i ++;
        }
        pack();
    }

    private void button_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_startActionPerformed
        // TODO add your handling code here:
        initCards();
    }//GEN-LAST:event_button_startActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold default-state="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePage().setVisible(true);
            }
        });
    }

    ////////////////////////// 窗体大小定义 //////////////////////////
    private int sizeTopImageHeight;  // 顶部图片高度
    private int sizeFrameWidth;  // 窗体宽度
    private int sizeFrameHeight; // 窗体高度
    private int sizeMainPanelWidth; // 主面板宽度
    private int sizeMainPanelHeight;    // 主面板高度
    private int sizeCardPoolWidth;   // 牌池宽度
    private int sizeCardPoolHeight;  // 牌池高度
    private int sizeOperatorWidth;   // 操作区宽度
    private int sizeOperatorHeight;  // 操作区高度
    private int sizeCardWidth;   // 牌宽度
    private int sizeCardHeight;  // 牌高度
    private int sizePlayerComWidth;  // 玩家组件宽度
    private int sizePlayerComHeight;  // 玩家组件高度
    private int sizeButtonWidth; // 按钮宽度
    private int sizeButtonHeight;    // 按钮高度
    private int sizePlayerWidth; // 玩家宽度
    private int sizePlayerHeight;    // 玩家高度

    ////////////////////////// 素材定义 //////////////////////////
    private javax.swing.ImageIcon iconTopImage; // 顶部图片
    private javax.swing.ImageIcon iconBackGround; // 背景图片
    private javax.swing.ImageIcon iconCardBack; // 牌背面
    private javax.swing.ImageIcon iconButton; // 按钮
    private javax.swing.ImageIcon icon;

    ////////////////////////// 组件 //////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_out;
    private javax.swing.JButton button_pass;
    private javax.swing.JButton button_start;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel label_topImage;
    private javax.swing.JPanel panel_cardPool;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_operateArea;
    private javax.swing.JPanel panel_player;
    private javax.swing.JPanel panel_playerCom1;
    private javax.swing.JPanel panel_playerCom2;
    private javax.swing.JPanel panel_topImage;
    // End of variables declaration//GEN-END:variables
}
