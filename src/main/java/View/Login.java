package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Admin.Admin;
import Employee.Employees;

public class Login extends javax.swing.JFrame {

	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JLabel cmdToSignup;

	public Login() {
		initModernComponents();
		setLocationRelativeTo(null);
	}

	public void login() {
		txtUser.grabFocus();
	}

	private void initModernComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Đăng Nhập - Hệ Thống Chấm Công");
		setResizable(false);

		// Main Panel với gradient background
		JPanel mainPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth(), h = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, new Color(67, 97, 238), 0, h, new Color(109, 213, 250));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);
			}
		};
		mainPanel.setLayout(new GridBagLayout());

		// Login Card Panel
		JPanel loginCard = new JPanel();
		loginCard.setBackground(Color.WHITE);
		loginCard.setLayout(new BoxLayout(loginCard, BoxLayout.Y_AXIS));
		loginCard.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(230, 230, 230), 1, true), new EmptyBorder(40, 50, 40, 50)));
		loginCard.setPreferredSize(new Dimension(450, 550));

		// Logo/Icon Panel
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		logoPanel.setMaximumSize(new Dimension(400, 100));

		JLabel iconLabel = new JLabel("⏰");
		iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 60));
		iconLabel.setForeground(new Color(67, 97, 238));
		logoPanel.add(iconLabel);

		// Title
		JLabel titleLabel = new JLabel("HỆ THỐNG CHẤM CÔNG");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		titleLabel.setForeground(new Color(33, 33, 33));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel subtitleLabel = new JLabel("Đăng nhập để tiếp tục");
		subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		subtitleLabel.setForeground(new Color(117, 117, 117));
		subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Username Field
		JLabel userLabel = new JLabel("Tên đăng nhập");
		userLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		userLabel.setForeground(new Color(66, 66, 66));
		userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtUser.setPreferredSize(new Dimension(380, 50));
		txtUser.setMaximumSize(new Dimension(380, 50));
		txtUser.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
						BorderFactory.createEmptyBorder(5, 18, 5, 18)));
		txtUser.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Password Field
		JLabel passLabel = new JLabel("Mật khẩu");
		passLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		passLabel.setForeground(new Color(66, 66, 66));
		passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtPassword.setPreferredSize(new Dimension(380, 50));
		txtPassword.setMaximumSize(new Dimension(380, 50));
		txtPassword.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
						BorderFactory.createEmptyBorder(5, 18, 5, 18)));
		txtPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Login Button
		btnLogin = new JButton("ĐĂNG NHẬP");
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(67, 97, 238));
		btnLogin.setPreferredSize(new Dimension(380, 50));
		btnLogin.setMaximumSize(new Dimension(380, 50));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogin.addActionListener(evt -> btnLoginActionPerformed(evt));

		// Hover effect cho button
		btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnLogin.setBackground(new Color(57, 87, 228));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnLogin.setBackground(new Color(67, 97, 238));
			}
		});

		// Sign Up Panel
		JPanel signupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		signupPanel.setBackground(Color.WHITE);
		signupPanel.setMaximumSize(new Dimension(380, 30));

		JLabel noAccLabel = new JLabel("Chưa có tài khoản?");
		noAccLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		noAccLabel.setForeground(new Color(117, 117, 117));

		cmdToSignup = new JLabel("Đăng ký ngay");
		cmdToSignup.setFont(new Font("Segoe UI", Font.BOLD, 13));
		cmdToSignup.setForeground(new Color(67, 97, 238));
		cmdToSignup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cmdToSignup.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				cmdToSignupMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				cmdToSignup.setForeground(new Color(57, 87, 228));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				cmdToSignup.setForeground(new Color(67, 97, 238));
			}
		});

		signupPanel.add(noAccLabel);
		signupPanel.add(cmdToSignup);

		// Add components to login card
		loginCard.add(logoPanel);
		loginCard.add(Box.createRigidArea(new Dimension(0, 10)));
		loginCard.add(titleLabel);
		loginCard.add(Box.createRigidArea(new Dimension(0, 5)));
		loginCard.add(subtitleLabel);
		loginCard.add(Box.createRigidArea(new Dimension(0, 35)));
		loginCard.add(userLabel);
		loginCard.add(Box.createRigidArea(new Dimension(0, 8)));
		loginCard.add(txtUser);
		loginCard.add(Box.createRigidArea(new Dimension(0, 20)));
		loginCard.add(passLabel);
		loginCard.add(Box.createRigidArea(new Dimension(0, 8)));
		loginCard.add(txtPassword);
		loginCard.add(Box.createRigidArea(new Dimension(0, 30)));
		loginCard.add(btnLogin);
		loginCard.add(Box.createRigidArea(new Dimension(0, 20)));
		loginCard.add(signupPanel);

		mainPanel.add(loginCard);

		setContentPane(mainPanel);
		setSize(900, 650);
	}

	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkAcc()) {
			String username = txtUser.getText().trim();
			String password = new String(txtPassword.getPassword());

			if (authenticate(username, password)) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader("data\\account.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");
						if (parts.length == 3) {
							String storedUsername = parts[0].trim();
							String storedPassword = parts[1].trim();
							int userType = Integer.parseInt(parts[2].trim());

							if (storedUsername.equals(username) && storedPassword.equals(password)) {
								if (userType == 0) {
									Admin adminFrame = new Admin();
									adminFrame.setVisible(true);
								} else if (userType == 1) {
									Employees empFrame = new Employees();
									empFrame.setVisible(true);
								}
								this.dispose();
								break;
							}
						}
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không chính xác", "Lỗi đăng nhập",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void cmdToSignupMouseClicked(java.awt.event.MouseEvent evt) {
		SignUp signUpWindow = new SignUp();
		signUpWindow.setVisible(true);
		this.setVisible(false);
	}

	private boolean checkAcc() {
		if (txtUser.getText().trim().isEmpty() && new String(txtPassword.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập tài khoản và mật khẩu", "Cảnh báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (txtUser.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (new String(txtPassword.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean authenticate(String username, String password) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data\\account.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 3) {
					String storedUsername = parts[0].trim();
					String storedPassword = parts[1].trim();
					if (storedUsername.equals(username) && storedPassword.equals(password)) {
						reader.close();
						return true;
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		java.awt.EventQueue.invokeLater(() -> {
			new Login().setVisible(true);
		});
	}
}