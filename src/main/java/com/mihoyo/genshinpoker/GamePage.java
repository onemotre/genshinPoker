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
        initComponentsStart(); // 在改界面添加发牌入口
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
        this.sizePlayerHeight = this.sizeCardHeight + 15;
        this.sizePlayerWidth = this.sizeFrameWidth;

        // 按键大小
        this.sizeButtonHeight = imageButton.getHeight(null) / 5;
        this.sizeButtonWidth = imageButton.getWidth(null) / 5;

        // 电脑组件大小
        this.sizePlayerComHeight = this.sizeMainPanelHeight - this.sizePlayerHeight;
        this.sizePlayerComWidth = this.sizeCardWidth + 6;

        // 操作区大小
        this.sizeOperatorHeight = this.sizeButtonHeight + 10;
        this.sizeOperatorWidth = this.sizeFrameWidth - 2 * this.sizePlayerComWidth;

        // 牌池大小
        this.sizeCardPoolHeight = this.sizePlayerComHeight - this.sizeOperatorHeight;
        this.sizeCardPoolWidth = imageBackGround.getWidth(null) - this.sizePlayerComWidth * 2;

        // 牌展示区大小
        this.sizeCardShowWidth = this.sizeFrameWidth / 19 - 3;
        this.sizeCardShowHeight = this.sizePlayerComHeight / 19 - 3;


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

    // Abort: Layout
//    private void initComponentsWithoutLayout() {
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        System.out.println(this.sizeFrameWidth + " " + this.sizeFrameHeight);
//
//        this.setIconImage(this.icon.getImage());
//        this.setTitle("GenShinPoker");
//
//        panel_player = new javax.swing.JPanel();
//        panel_playerCom1 = new javax.swing.JPanel();
//        panel_playerCom2 = new javax.swing.JPanel();
//        panel_cardPool = new javax.swing.JPanel();
//        panel_operateArea = new javax.swing.JPanel();
//        button_start = new javax.swing.JButton();
//        button_out = new javax.swing.JButton();
//        button_pass = new javax.swing.JButton();
//        label_topImage = new javax.swing.JLabel();
//        label_background = new javax.swing.JLabel();
//
//        panel_playerCom1.setOpaque(false);
//        panel_playerCom1.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
//        panel_playerCom1.setBounds(0, this.sizeTopImageHeight, this.sizePlayerComWidth, this.sizePlayerComHeight);
//
//
//        panel_cardPool.setOpaque(false);
//        panel_cardPool.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
//        panel_cardPool.setBounds(this.sizePlayerComWidth, this.sizeTopImageHeight, this.sizeCardPoolWidth, this.sizeCardPoolHeight);
//
//
//        panel_playerCom2.setOpaque(false);
//        panel_playerCom2.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
//        panel_playerCom2.setBounds(this.sizePlayerComWidth + this.sizeCardPoolWidth, this.sizeTopImageHeight, this.sizePlayerComWidth, this.sizePlayerComHeight);
//
//
//        panel_operateArea.setLayout(new java.awt.GridLayout());
//        GridLayout gridLayout = new GridLayout(1, 3);
//        panel_operateArea.setOpaque(false);
//        panel_operateArea.setBounds(this.sizePlayerComWidth, this.sizeTopImageHeight + this.sizeCardPoolHeight, this.sizeOperatorWidth, this.sizeOperatorHeight);
//
//        button_start.setIcon(this.iconButton);
//        button_start.setText("开始游戏");
//        button_start.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//        button_start.setVerticalTextPosition(SwingConstants.CENTER);
//        button_start.setBorderPainted(false);
//        button_start.setContentAreaFilled(false);
//        button_start.setFocusPainted(false);
//        panel_operateArea.add(button_start, gridLayout);
//
//        button_out.setIcon(this.iconButton);
//        button_out.setText("出牌");
//        button_out.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//        button_out.setVerticalTextPosition(SwingConstants.CENTER);
//        button_out.setBorderPainted(false);
//        button_out.setContentAreaFilled(false);
//        button_out.setFocusPainted(false);
//        panel_operateArea.add(button_out, gridLayout);
//
//        button_pass.setIcon(this.iconButton);
//        button_pass.setText("不出");
//        button_pass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//        button_pass.setVerticalTextPosition(SwingConstants.CENTER);
//        button_pass.setBorderPainted(false);
//        button_pass.setContentAreaFilled(false);
//        button_pass.setFocusPainted(false);
//        panel_operateArea.add(button_pass, gridLayout);
//
//        panel_player.setOpaque(false);
//        panel_player.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
//        panel_player.setBounds(0, this.sizeTopImageHeight + this.sizeCardPoolHeight + this.sizeOperatorHeight, this.sizePlayerWidth, this.sizePlayerHeight);
//
//
//
//        getContentPane().add(panel_playerCom1);
//        getContentPane().add(panel_cardPool);
//        getContentPane().add(panel_playerCom2);
//        getContentPane().add(panel_operateArea);
//        getContentPane().add(panel_player);
//
//
//        label_topImage.setOpaque(false);
//        label_topImage.setBounds(0, 0, this.sizeFrameWidth, this.sizeTopImageHeight);
//        label_topImage.setIcon(this.iconTopImage);
//        getContentPane().add(label_topImage);
//        label_background.setOpaque(false);
//        label_background.setBounds(0, this.sizeTopImageHeight, this.sizeFrameWidth, this.sizeMainPanelHeight);
//        label_background.setIcon(this.iconBackGround);
//        getContentPane().add(label_background);
//
//        pack();
//    }
//    private void initComponents() {
//        java.awt.GridBagConstraints gridBagConstraints;
//
//        panel_topImage = new javax.swing.JPanel();
//        panel_main = new javax.swing.JPanel();
//        panel_player = new javax.swing.JPanel();
//        panel_playerCom1 = new javax.swing.JPanel();
//        panel_playerCom2 = new javax.swing.JPanel();
//        panel_cardPool = new javax.swing.JPanel();
//        panel_operateArea = new javax.swing.JPanel();
//        button_start = new javax.swing.JButton();
//        button_out = new javax.swing.JButton();
//        button_pass = new javax.swing.JButton();
//        label_topImage = new javax.swing.JLabel();
//        label_background = new javax.swing.JLabel();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        getContentPane().setLayout(new java.awt.GridBagLayout());
//        this.setIconImage(this.icon.getImage());
//        this.setTitle("GenShinPoker");
//
//        panel_topImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//        panel_topImage.setOpaque(false);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 0;
//        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
//        getContentPane().add(panel_topImage, gridBagConstraints);
//
//        panel_main.setLayout(new java.awt.GridBagLayout());
//        panel_main.setOpaque(false);
//        panel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
//
//        panel_player.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//        panel_player.setOpaque(false);
//
//        JLabel test = new JLabel();
//        ImageIcon icon = new ImageIcon(Card.getCardPicUrl(1));
//        Image image = icon.getImage();
//        Image newImage = image.getScaledInstance(this.sizeCardWidth, this.sizeCardHeight, java.awt.Image.SCALE_SMOOTH);
//        icon.setImage(newImage);
//        test.setIcon(icon);
//        test.setSize(this.sizeCardWidth, this.sizeCardHeight);
//        test.setOpaque(false);
//        panel_player.add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, this.sizeCardWidth, this.sizeCardHeight));
//
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 1;
//        gridBagConstraints.gridy = 3;
//        gridBagConstraints.gridwidth = 3;
//        gridBagConstraints.gridheight = 1;
//        gridBagConstraints.fill = GridBagConstraints.BOTH;
//        panel_main.add(panel_player, new java.awt.GridBagConstraints());
//        panel_player.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
//
//        panel_playerCom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//        panel_playerCom1.setOpaque(false);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 1;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.gridwidth = 1;
//        gridBagConstraints.gridheight = 2;
//        panel_main.add(panel_playerCom1, new java.awt.GridBagConstraints());
//
//        panel_playerCom2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//        panel_playerCom2.setOpaque(false);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 3;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.gridwidth = 1;
//        gridBagConstraints.gridheight = 2;
//        panel_main.add(panel_playerCom2, new java.awt.GridBagConstraints());
//
//        panel_cardPool.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//        // 显示panel_cardPool的边框
//        panel_cardPool.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 2;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.gridwidth = 1;
//        gridBagConstraints.gridheight = 1;
//        panel_main.add(panel_cardPool, new java.awt.GridBagConstraints());
//
//        panel_operateArea.setLayout(new java.awt.GridBagLayout());
//        panel_operateArea.setOpaque(false);
//
//
//        button_start.setIcon(this.iconButton);
//        button_start.setText("开始游戏");
//        button_start.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//        button_start.setVerticalTextPosition(SwingConstants.CENTER);
//        button_start.setBorderPainted(false);
//        button_start.setContentAreaFilled(false);
//        button_start.setFocusPainted(false);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 1;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.weightx = this.sizeFrameWidth;
//        gridBagConstraints.weighty = this.sizeFrameHeight;
//        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
//        panel_operateArea.add(button_start, gridBagConstraints);
//
//        button_out.setIcon(this.iconButton);
//        button_out.setText("出牌");
//        button_out.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//        button_out.setVerticalTextPosition(SwingConstants.CENTER);
//        button_out.setBorderPainted(false);
//        button_out.setContentAreaFilled(false);
//        button_out.setFocusPainted(false);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 2;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.weightx = this.sizeFrameWidth;
//        gridBagConstraints.weighty = this.sizeFrameHeight;
//        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
//        panel_operateArea.add(button_out, gridBagConstraints);
//
//        button_pass.setIcon(this.iconButton);
//        button_pass.setText("不出");
//        button_pass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//        button_pass.setVerticalTextPosition(SwingConstants.CENTER);
//        button_pass.setBorderPainted(false);
//        button_pass.setContentAreaFilled(false);
//        button_pass.setFocusPainted(false);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 3;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.weightx = this.sizeFrameWidth;
//        gridBagConstraints.weighty = this.sizeFrameHeight;
//        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
//        panel_operateArea.add(button_pass, gridBagConstraints);
//
//        // panel_operateArea 在 panel_main 中的位置
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 2;
//        gridBagConstraints.gridy = 2;
//        gridBagConstraints.gridwidth = 1;
//        gridBagConstraints.gridheight = 1;
//        panel_main.add(panel_operateArea, new java.awt.GridBagConstraints());
//
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
//        getContentPane().add(panel_main, gridBagConstraints);
//
//        label_topImage.setIcon(this.iconTopImage);
//        label_topImage.setOpaque(false);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 0;
//        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
//        getContentPane().add(label_topImage, gridBagConstraints);
//
//        label_background.setIcon(this.iconBackGround);
//        label_background.setOpaque(false);
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 1;
//        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
//        getContentPane().add(label_background, gridBagConstraints);
//        pack();
//
//        button_start.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                System.out.println("开始游戏");
//                button_startActionPerformed(evt);
//            }
//        });
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
    /**
     * &#064;brief  初始化未发牌的界面
     * &#064;date  2023-12-17 03:00:00
     * &#064;note:  狗屎GridBagLayout
     */
    private void initComponentsStart() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        this.setIconImage(this.icon.getImage());
        this.setTitle("GenShinPoker");

        label_topImage = new javax.swing.JLabel();
        label_background = new javax.swing.JLabel();
        panel_cardPool = new javax.swing.JPanel();  // 此处的cardPool纯属给operatorArea
        panel_operateArea = new javax.swing.JPanel();

        button_start = new javax.swing.JButton();
        button_out = new javax.swing.JButton();
        button_pass = new javax.swing.JButton();

        // label_topImage
        label_topImage.setIcon(this.iconTopImage);
        label_topImage.setOpaque(false);
        getContentPane().add(label_topImage,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0,
                        this.sizeFrameWidth, this.sizeTopImageHeight));

        // panel_operateArea
        panel_operateArea.setLayout(new java.awt.GridLayout());
        GridLayout gridLayout = new GridLayout(1, 1);
        panel_operateArea.setOpaque(false);

        button_start.setIcon(this.iconButton);
        button_start.setText("开始游戏");
        button_start.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_start.setVerticalTextPosition(SwingConstants.CENTER);
        button_start.setBorderPainted(false);
        button_start.setContentAreaFilled(false);
        button_start.setFocusPainted(false);
        // 游戏界面入口
        button_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("开始游戏");
                button_startActionPerformed(evt);
            }
        });
        panel_operateArea.add(button_start, gridLayout);

        // TODO: 要不要添加作者信息之类的按钮？
        getContentPane().add(panel_operateArea,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(this.sizePlayerComWidth,
                        this.sizeTopImageHeight + this.sizeMainPanelHeight / 2,
                        this.sizeOperatorWidth, this.sizeOperatorHeight));

        // label_background
        label_background.setIcon(this.iconBackGround);
        label_background.setOpaque(false);
        getContentPane().add(label_background,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, this.sizeTopImageHeight,
                        this.sizeFrameWidth, this.sizeMainPanelHeight));
        pack();
    }

    /**
     * &#064;brief  初始化发牌界面
     * &#064;date  2023-12-17 15:00:00
     */
    private void initComponentsGame() {
        // 清除窗口所有组件
        getContentPane().removeAll();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        this.setIconImage(this.icon.getImage());
        this.setTitle("GenShinPoker");

        label_topImage = new javax.swing.JLabel();
        label_background = new javax.swing.JLabel();
        panel_playerCom1 = new javax.swing.JPanel();
        panel_playerCom2 = new javax.swing.JPanel();
        panel_player = new javax.swing.JPanel();
        panel_cardPool = new javax.swing.JPanel();
        panel_operateArea = new javax.swing.JPanel();
        panel_main = new javax.swing.JPanel();

        // 渲染卡组
        // 玩家
        updatePlayerPanel();

        // 电脑玩家1
        panel_playerCom1 = updateComPanel(this.player2Card);
        panel_playerCom1.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        getContentPane().add(panel_playerCom1,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(
                        0, this.sizeTopImageHeight,
                        this.sizePlayerComWidth, this.sizePlayerComHeight));
        // 电脑玩家2
        panel_playerCom2 = updateComPanel(this.player3Card);
        panel_playerCom2.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        getContentPane().add(panel_playerCom2,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(
                        this.sizePlayerComWidth + this.sizeCardPoolWidth, this.sizeTopImageHeight,
                        this.sizePlayerComWidth, this.sizePlayerComHeight));

        // 操作区渲染
        panel_operateArea.setLayout(new java.awt.GridLayout());
        GridLayout gridLayout = new GridLayout(1, 2);
        panel_operateArea.setOpaque(false);

        button_out.setIcon(this.iconButton);
        button_out.setText("出牌");
        button_out.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_out.setVerticalTextPosition(SwingConstants.CENTER);
        button_out.setBorderPainted(false);
        button_out.setContentAreaFilled(false);
        button_out.setFocusPainted(false);
        panel_operateArea.add(button_out, gridLayout);
        button_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("出牌");
                button_outActionPerformed(evt);
            }
        });

        button_pass.setIcon(this.iconButton);
        button_pass.setText("不出");
        button_pass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_pass.setVerticalTextPosition(SwingConstants.CENTER);
        button_pass.setBorderPainted(false);
        button_pass.setContentAreaFilled(false);
        button_pass.setFocusPainted(false);
        panel_operateArea.add(button_pass, gridLayout);

        getContentPane().add(panel_operateArea,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(
                        this.sizePlayerComWidth, this.sizeTopImageHeight + this.sizeCardPoolHeight,
                        this.sizeOperatorWidth, this.sizeOperatorHeight));

        // 牌池渲染
        panel_cardPool.setOpaque(false);
        panel_cardPool.setLayout(new java.awt.BorderLayout());
        panel_cardPool.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        getContentPane().add(panel_cardPool, new org.netbeans.lib.awtextra.AbsoluteConstraints(
                this.sizePlayerComWidth, this.sizeTopImageHeight,
                this.sizeCardPoolWidth, this.sizeCardPoolHeight));

        // 背景渲染
        label_topImage.setIcon(this.iconTopImage);
        label_topImage.setOpaque(false);
        getContentPane().add(label_topImage,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(
                        0, 0, this.sizeFrameWidth, this.sizeTopImageHeight));
        label_background.setIcon(this.iconBackGround);
        label_background.setOpaque(false);
        getContentPane().add(label_background,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(
                        0, this.sizeTopImageHeight, this.sizeFrameWidth, this.sizeMainPanelHeight));

        pack();
    }


    ///////////////////////// 事件逻辑 /////////////////////////
    /**
     * 更新玩家牌组
     */
    private void updatePlayerPanel() {
        javax.swing.JLabel[] player1CardLabel = new javax.swing.JLabel[this.player1Card.getCardNum()];

        // 清除原来panel中的label
        this.panel_player.removeAll();
        // 渲染玩家的牌
        this.panel_player.setOpaque(false);
        this.panel_player.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        for (int i = this.player1Card.getCardNum() - 1; i >= 0; i--) {
            setCardsLabel(player1CardLabel, i);
            int posX = (this.sizeFrameWidth - this.sizeCardShowWidth * 19) / 2 + i * this.sizeCardShowWidth;
            this.panel_player.add(player1CardLabel[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(posX, 10));
        }
        panel_player.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        getContentPane().add(panel_player,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(
                        0, this.sizePlayerComHeight + this.sizeTopImageHeight,
                        this.sizePlayerWidth, this.sizePlayerHeight));
        panel_player.repaint();
    }

    /**
     * 更新电脑玩家牌组
     * @param _playerComCard 电脑玩家牌组
     * @return 电脑玩家牌组（需要用具体panel接收）
     */
    private javax.swing.JPanel updateComPanel(Card _playerComCard) {
        javax.swing.JPanel panel_playerCom = new javax.swing.JPanel();
        panel_playerCom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        javax.swing.JLabel[] playerComCardLabel = new javax.swing.JLabel[_playerComCard.getCardNum()];

        // 渲染电脑玩家的牌
        panel_playerCom.setOpaque(false);
        for (int i = _playerComCard.getCardNum() - 1; i >= 0 ; i--) {
            // 展示牌面
            // setCardsLabel(playerComCardLabel, i);

            playerComCardLabel[i] = new JLabel();
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/mihoyo/genshinpoker/images/pokerCard/back.jpg")));
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(this.sizeCardWidth, this.sizeCardHeight, Image.SCALE_SMOOTH);
            icon.setImage(newImage);
            playerComCardLabel[i].setIcon(icon);

            int posY = (this.sizePlayerComHeight - this.sizeCardShowHeight * 19) / 2 + i * this.sizeCardShowHeight;
            panel_playerCom.add(playerComCardLabel[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, posY));
        }
        return panel_playerCom;
    }

    /**
     * 出牌逻辑
     * @param _player   玩家: 1. 玩家; 2. 电脑1; 3. 电脑2
     * @param _outCards 出的牌（已经经过检验）
     */
    private void outCards(int _player, Card _outCards) {
        // 更新牌池
        updateCardPool(_player, _outCards);

        this.selectedCards = new Card(new ArrayList<>());
        this.foreCards = new Card(_outCards.getCards());

        // 玩家处理
        if (_player == 1) {
            // 更新玩家牌组
            this.player1Card.removeCards(_outCards.getCards());
            System.out.println("玩家手牌：" + this.player1Card.getCards());
            initComponentsGame();
        } else if (_player == 2) {
            this.player2Card.removeCards(_outCards.getCards());
            this.panel_playerCom1 = updateComPanel(this.player2Card);
        } else {
            this.player3Card.removeCards(_outCards.getCards());
            this.panel_playerCom2 = updateComPanel(this.player3Card);
        }
    }
    /**
     * 更新牌池
     * @param _player 玩家: 1. 玩家; 2. 电脑1; 3. 电脑2
     * @param _outCard 出的牌
     */
    private void updateCardPool(int _player, Card _outCard) {
        javax.swing.JPanel panel_cardOut = new javax.swing.JPanel();
        panel_cardOut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_cardOut.setOpaque(false);

        javax.swing.JLabel[] cardOutLabel = new javax.swing.JLabel[_outCard.getCardNum()];

        for (int i = 0; i < _outCard.getCardNum(); i++) {
            ImageIcon icon = new ImageIcon(Card.getCardPicUrl(_outCard.getCards().get(i)));
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(this.sizeCardWidth, this.sizeCardHeight, Image.SCALE_SMOOTH);
            icon.setImage(newImage);

            cardOutLabel[i] = new JLabel();
            cardOutLabel[i].setIcon(icon);
            cardOutLabel[i].setSize(this.sizeCardWidth, this.sizeCardHeight);
            cardOutLabel[i].setOpaque(false);

            int posX = (this.sizeCardPoolWidth - this.sizeCardShowWidth * 19) / 2 + i * this.sizeCardShowWidth;
            panel_cardOut.add(cardOutLabel[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(posX, 0));
        }
        panel_cardOut.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        if (_player == 1) {
            panel_cardPool.add(panel_cardOut, BorderLayout.LINE_END);
        } else if(_player == 2){
            panel_cardPool.add(panel_cardOut, BorderLayout.WEST);
        } else {
            panel_cardPool.add(panel_cardOut, BorderLayout.EAST);
        }
        panel_cardPool.revalidate();
        panel_cardPool.repaint();
    }

    /**
     * 设置牌的label
     * @param cardOutLabel 等待设置的牌组
     * @param i 牌的序号
     */
    private void setCardsLabel(JLabel[] cardOutLabel, int i) {
        Integer _code = this.player1Card.getCards().get(i);
        cardOutLabel[i] = new JLabel();
        ImageIcon icon = new ImageIcon(Card.getCardPicUrl(_code));
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(this.sizeCardWidth, this.sizeCardHeight, Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        cardOutLabel[i].setIcon(icon);
        cardOutLabel[i].setSize(this.sizeCardWidth, this.sizeCardHeight);
        cardOutLabel[i].setOpaque(false);
        cardOutLabel[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("点击了牌" + _code);
                cardOutLabelMouseClicked(evt, _code);
            }
        });
    }

    //////////////////////// 处理事件 ////////////////////////

    /**
     * 开始游戏事件（发牌）
     */
    private void button_startActionPerformed(java.awt.event.ActionEvent evt) {
        // 初始化牌组
        ArrayList<ArrayList<Integer>> puke = Card.licensing(3);
        ArrayList<Integer> player1 = puke.get(0);
        this.player1Card = new Card(Card.sortCards(player1));
        ArrayList<Integer> player2 = puke.get(1);
        this.player2Card = new Card(Card.sortCards(player2));
        ArrayList<Integer> player3 = puke.get(2);
        this.player3Card = new Card(Card.sortCards(player3));

        System.out.println("玩家手牌：" + this.player1Card.getCards());
        System.out.println("电脑1手牌：" + this.player2Card.getCards());
        System.out.println("电脑2手牌：" + this.player3Card.getCards());

        this.foreCards = new Card(new ArrayList<>());
        this.selectedCards = new Card(new ArrayList<>());
        this.outCards = new Card(new ArrayList<>());

        initComponentsGame();
    }

    /**
     * 出牌事件
     */
    private void button_outActionPerformed(java.awt.event.ActionEvent evt) {
        this.outCards = new Card(selectedCards.getCards());
        boolean OutAble = Card.compare(this.selectedCards.getCards(), this.foreCards.getCards());
        if (OutAble) {
            System.out.println("--------------出牌符合规则--------------");
            System.out.println("出牌：" + this.outCards.getCards());
            System.out.println("类型：" + Card.getType(this.outCards.getCards()));
            System.out.println("上手：" + this.foreCards.getCards());
            System.out.println("上手类型：" + Card.getType(this.foreCards.getCards()));
            this.outCards(1, this.selectedCards);
        } else {
            System.out.println("--------------出牌不符合规则--------------");
            // 将所有选中的牌在牌原来的位置上向下移动5个像素
            for (int i = 0; i < this.selectedCards.getCardNum(); i++) {
                int originalI = this.player1Card.getCards().indexOf(this.selectedCards.getCards().get(i));
                int posX = (this.sizeFrameWidth - this.sizeCardShowWidth * 19) / 2 + originalI * this.sizeCardShowWidth;
                int originIndex = this.panel_player.getComponentZOrder(this.panel_player.getComponent(i));
                this.panel_player.getComponent(originIndex).setLocation(posX, 10);
            }
            selectedCards = new Card(new ArrayList<>());
        }
    }

    /**
     * 点击牌事件
     *
     */
    private void cardOutLabelMouseClicked(java.awt.event.MouseEvent evt, Integer _code) {
        boolean isSelected = this.selectedCards.getCards().contains(_code);
        if (isSelected) {
            // 取消选中
            this.selectedCards.deleteCard(_code);
            // 选中的牌向下移动5个像素
            evt.getComponent().setLocation(evt.getComponent().getX(), evt.getComponent().getY() + 15);
        } else {
            // 选中
            this.selectedCards.addCard(_code);
            // 选中的牌向上移动5个像素
            evt.getComponent().setLocation(evt.getComponent().getX(), evt.getComponent().getY() - 15);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

        // 显示：
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GamePage jf = new GamePage();
                jf.setVisible(true);
            }
        });
    }

    ////////////////////////// 逻辑变量 //////////////////////////
    private Card player1Card;   // 玩家手牌
    private Card player2Card;   // 电脑玩家手牌
    private Card player3Card;   // 电脑玩家手牌
    private Card selectedCards; // 选中的牌
    private Card foreCards; // 上一次出的牌
    private Card outCards;  // 出的牌

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
    private int sizeCardShowWidth;  // 牌展示区宽度（玩家区域）
    private int sizeCardShowHeight; // 牌展示区高度（电脑区域）
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
}
