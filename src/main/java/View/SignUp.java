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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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

public class SignUp extends javax.swing.JFrame {

	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JPasswordField txtRepeatPassword;
	private JButton btnSignUp;
	private JLabel cmdToLogin;

	public SignUp() {
		initModernComponents();
		setLocationRelativeTo(null);
	}

	public void signUp() {
		txtUser.grabFocus();
	}

	private void initModernComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Đăng Ký - Hệ Thống Chấm Công");
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

		// SignUp Card Panel
		JPanel signupCard = new JPanel();
		signupCard.setBackground(Color.WHITE);
		signupCard.setLayout(new BoxLayout(signupCard, BoxLayout.Y_AXIS));
		signupCard.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(230, 230, 230), 1, true), new EmptyBorder(40, 50, 40, 50)));
		signupCard.setPreferredSize(new Dimension(450, 620));

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
		JLabel titleLabel = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		titleLabel.setForeground(new Color(33, 33, 33));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel subtitleLabel = new JLabel("Tạo tài khoản mới");
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

		// Repeat Password Field
		JLabel repeatPassLabel = new JLabel("Nhập lại mật khẩu");
		repeatPassLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		repeatPassLabel.setForeground(new Color(66, 66, 66));
		repeatPassLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		txtRepeatPassword = new JPasswordField();
		txtRepeatPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtRepeatPassword.setPreferredSize(new Dimension(380, 50));
		txtRepeatPassword.setMaximumSize(new Dimension(380, 50));
		txtRepeatPassword.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
						BorderFactory.createEmptyBorder(5, 18, 5, 18)));
		txtRepeatPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

		// SignUp Button
		btnSignUp = new JButton("ĐĂNG KÝ");
		btnSignUp.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(67, 97, 238));
		btnSignUp.setPreferredSize(new Dimension(380, 50));
		btnSignUp.setMaximumSize(new Dimension(380, 50));
		btnSignUp.setFocusPainted(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSignUp.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSignUp.addActionListener(evt -> btnSignUpActionPerformed(evt));

		// Hover effect cho button
		btnSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnSignUp.setBackground(new Color(57, 87, 228));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSignUp.setBackground(new Color(67, 97, 238));
			}
		});

		// Login Panel
		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setMaximumSize(new Dimension(380, 30));

		JLabel haveAccLabel = new JLabel("Đã có tài khoản?");
		haveAccLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		haveAccLabel.setForeground(new Color(117, 117, 117));

		cmdToLogin = new JLabel("Đăng nhập ngay");
		cmdToLogin.setFont(new Font("Segoe UI", Font.BOLD, 13));
		cmdToLogin.setForeground(new Color(67, 97, 238));
		cmdToLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cmdToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				cmdToLoginMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				cmdToLogin.setForeground(new Color(57, 87, 228));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				cmdToLogin.setForeground(new Color(67, 97, 238));
			}
		});

		loginPanel.add(haveAccLabel);
		loginPanel.add(cmdToLogin);

		// Add components to signup card
		signupCard.add(logoPanel);
		signupCard.add(Box.createRigidArea(new Dimension(0, 10)));
		signupCard.add(titleLabel);
		signupCard.add(Box.createRigidArea(new Dimension(0, 5)));
		signupCard.add(subtitleLabel);
		signupCard.add(Box.createRigidArea(new Dimension(0, 30)));
		signupCard.add(userLabel);
		signupCard.add(Box.createRigidArea(new Dimension(0, 8)));
		signupCard.add(txtUser);
		signupCard.add(Box.createRigidArea(new Dimension(0, 15)));
		signupCard.add(passLabel);
		signupCard.add(Box.createRigidArea(new Dimension(0, 8)));
		signupCard.add(txtPassword);
		signupCard.add(Box.createRigidArea(new Dimension(0, 15)));
		signupCard.add(repeatPassLabel);
		signupCard.add(Box.createRigidArea(new Dimension(0, 8)));
		signupCard.add(txtRepeatPassword);
		signupCard.add(Box.createRigidArea(new Dimension(0, 25)));
		signupCard.add(btnSignUp);
		signupCard.add(Box.createRigidArea(new Dimension(0, 20)));
		signupCard.add(loginPanel);

		mainPanel.add(signupCard);

		setContentPane(mainPanel);
		setSize(900, 700);
	}

	private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkSignup()) {
			String username = txtUser.getText().trim();
			String password = new String(txtPassword.getPassword()).trim();
			int userType = 1;

			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("data\\account.txt", true));
				writer.write(username + "," + password + "," + userType);
				writer.newLine();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi lưu tài khoản", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			JOptionPane.showMessageDialog(this, "Đăng ký tài khoản thành công!", "Thành công",
					JOptionPane.INFORMATION_MESSAGE);
			clearTxtField();

			Login loginWindow = new Login();
			loginWindow.setVisible(true);
			this.setVisible(false);
		}
	}

	private void cmdToLoginMouseClicked(java.awt.event.MouseEvent evt) {
		Login loginWindow = new Login();
		loginWindow.setVisible(true);
		this.setVisible(false);
	}

	private boolean checkSignup() {
		if (txtUser.getText().trim().isEmpty() && new String(txtPassword.getPassword()).isEmpty()
				&& new String(txtRepeatPassword.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ các trường", "Cảnh báo",
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
		if (new String(txtRepeatPassword.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập lại mật khẩu", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (!Arrays.equals(txtRepeatPassword.getPassword(), txtPassword.getPassword())) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private void clearTxtField() {
		txtUser.setText("");
		txtUser.grabFocus();
		txtPassword.setText("");
		txtRepeatPassword.setText("");
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		java.awt.EventQueue.invokeLater(() -> {
			new SignUp().setVisible(true);
		});
	}
}