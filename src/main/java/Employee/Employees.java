package Employee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import View.Login;

public class Employees extends javax.swing.JFrame {

	private JTextField txtName, txtPhone, txtEmail, txtRole;
	private JComboBox<String> cboGender, cboDay, cboMonth, cboYear;
	private JButton btnUpdateInfo;

	private JTable tblSchedule;
	private DefaultTableModel scheduleModel;
	private JComboBox<String> cboShift;
	private JButton btnRegisterSchedule;

	private JTable tblAttendance;
	private DefaultTableModel attendanceModel;
	private JButton btnCheckIn, btnCheckOut;

	private JLabel lblTotalShiftsValue, lblTotalOTValue, lblTotalSalaryValue;

	public Employees() {
		initModernComponents();
		setLocationRelativeTo(null);
	}

	private void initModernComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Nhân Viên - Hệ Thống Chấm Công");
		setResizable(false);
		setSize(1200, 800);

// Main Panel với gradient xanh biển đơn giản
		JPanel mainPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				int w = getWidth(), h = getHeight();
// Gradient xanh biển nhẹ nhàng
				GradientPaint gp = new GradientPaint(0, 0, new Color(59, 130, 246), w, h, new Color(37, 99, 235));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);
			}
		};
		mainPanel.setLayout(new BorderLayout(20, 20));
		mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

// Header Panel với thiết kế sạch sẽ
		JPanel headerPanel = createHeaderPanel();

// Content Card với border bo tròn nhẹ
		JPanel contentCard = new JPanel();
		contentCard.setBackground(Color.WHITE);
		contentCard.setLayout(new BorderLayout());
		contentCard.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(229, 231, 235), 1), new EmptyBorder(20, 20, 20, 20)));

// Tabbed Pane với style tối giản
		JTabbedPane mainTabbedPane = new JTabbedPane();
		mainTabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mainTabbedPane.setBackground(Color.WHITE);
		mainTabbedPane.setForeground(new Color(55, 65, 81));

		mainTabbedPane.addTab("Thông tin cá nhân", createPersonalInfoPanel());
		mainTabbedPane.addTab("Đăng ký ca làm", createSchedulePanel());
		mainTabbedPane.addTab("Chấm công", createAttendancePanel());
		mainTabbedPane.addTab("Lương tháng", createSalaryPanel());

		contentCard.add(mainTabbedPane, BorderLayout.CENTER);

		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(contentCard, BorderLayout.CENTER);

		setContentPane(mainPanel);
	}

	private JPanel createHeaderPanel() {
		JPanel headerPanel = new JPanel();
		headerPanel.setOpaque(false);
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setPreferredSize(new Dimension(0, 70));

		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		titlePanel.setOpaque(false);

		JLabel titleLabel = new JLabel("MENU NHÂN VIÊN");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
		titleLabel.setForeground(Color.WHITE);

		titlePanel.add(titleLabel);

		JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		logoutPanel.setOpaque(false);

		JButton btnLogout = createModernButton("Đăng xuất", new Color(239, 68, 68), new Color(220, 38, 38));
		btnLogout.setPreferredSize(new Dimension(150, 50));
		btnLogout.addActionListener(evt -> btnLogoutClicked());

		logoutPanel.add(btnLogout);

		headerPanel.add(titlePanel, BorderLayout.WEST);
		headerPanel.add(logoutPanel, BorderLayout.EAST);

		return headerPanel;
	}

	private JPanel createPersonalInfoPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout(0, 20));
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));

		JLabel titleLabel = new JLabel("Thông tin cá nhân");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		titleLabel.setForeground(new Color(31, 41, 55));

		JPanel formPanel = new JPanel();
		formPanel.setBackground(Color.WHITE);
		formPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 15, 10, 15);

// Họ và tên
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		formPanel.add(createLabel("Họ và tên:"), gbc);
		gbc.gridx = 1;
		gbc.weightx = 1;
		txtName = createModernTextField();
		formPanel.add(txtName, gbc);

// Email
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		formPanel.add(createLabel("Email:"), gbc);
		gbc.gridx = 1;
		gbc.weightx = 1;
		txtEmail = createModernTextField();
		formPanel.add(txtEmail, gbc);

// Số điện thoại
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		formPanel.add(createLabel("Số điện thoại:"), gbc);
		gbc.gridx = 1;
		gbc.weightx = 1;
		txtPhone = createModernTextField();
		formPanel.add(txtPhone, gbc);

// Giới tính
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		formPanel.add(createLabel("Giới tính:"), gbc);
		gbc.gridx = 1;
		gbc.weightx = 1;
		cboGender = createModernComboBox(new String[] { "Nam", "Nữ", "Khác" });
		formPanel.add(cboGender, gbc);

// Ngày sinh
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		formPanel.add(createLabel("Ngày sinh:"), gbc);
		gbc.gridx = 1;
		gbc.weightx = 1;

		JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		datePanel.setBackground(Color.WHITE);

		JLabel lblDay = createLabel("Ngày:");
		JLabel lblMonth = createLabel("Tháng:");
		JLabel lblYear = createLabel("Năm:");

		cboDay = createModernComboBox(generateNumbers(1, 31));
		cboMonth = createModernComboBox(generateNumbers(1, 12));
		cboYear = createModernComboBox(generateNumbers(1950, 2010));

		datePanel.add(lblDay);
		datePanel.add(cboDay);
		datePanel.add(lblMonth);
		datePanel.add(cboMonth);
		datePanel.add(lblYear);
		datePanel.add(cboYear);

		formPanel.add(datePanel, gbc);

// Chức vụ
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0;
		formPanel.add(createLabel("Chức vụ:"), gbc);
		gbc.gridx = 1;
		gbc.weightx = 1;
		txtRole = createModernTextField();
		formPanel.add(txtRole, gbc);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(Color.WHITE);

		btnUpdateInfo = createModernButton("CẬP NHẬT THÔNG TIN", new Color(59, 130, 246), new Color(37, 99, 235));
		btnUpdateInfo.setPreferredSize(new Dimension(250, 50));
		btnUpdateInfo.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		});
		buttonPanel.add(btnUpdateInfo);

		panel.add(titleLabel, BorderLayout.NORTH);
		panel.add(formPanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createSchedulePanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout(0, 20));
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));

		JLabel titleLabel = new JLabel("Đăng ký lịch làm việc");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		titleLabel.setForeground(new Color(31, 41, 55));

// Form đăng ký đơn giản
		JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		formPanel.setBackground(Color.WHITE);

		formPanel.add(createLabel("Chọn ca làm:"));
		cboShift = createModernComboBox(
				new String[] { "Ca sáng (07:00 - 12:00)", "Ca chiều (13:00 - 18:00)", "Ca tối (18:00 - 23:00)" });
		cboShift.setPreferredSize(new Dimension(220, 40));
		formPanel.add(cboShift);

		btnRegisterSchedule = createModernButton("ĐĂNG KÝ", new Color(59, 130, 246), new Color(37, 99, 235));
		btnRegisterSchedule.setPreferredSize(new Dimension(140, 40));
		btnRegisterSchedule.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Đăng ký ca làm thành công!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		});
		formPanel.add(btnRegisterSchedule);

// Bảng lịch làm việc
		String[] columns = { "Ngày", "Ca làm", "Giờ vào", "Giờ ra", "Trạng thái" };
		scheduleModel = new DefaultTableModel(columns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		scheduleModel.addRow(new Object[] { "2025-10-21", "Ca sáng", "07:00", "12:00", "Đã đăng ký" });
		scheduleModel.addRow(new Object[] { "2025-10-22", "Ca chiều", "13:00", "18:00", "Đã đăng ký" });
		scheduleModel.addRow(new Object[] { "2025-10-23", "Ca sáng", "07:00", "12:00", "Chưa checkin" });

		tblSchedule = createModernTable(scheduleModel);
		JScrollPane scrollPane = new JScrollPane(tblSchedule);
		scrollPane.setPreferredSize(new Dimension(0, 400));
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(229, 231, 235), 1));

		panel.add(titleLabel, BorderLayout.NORTH);
		panel.add(formPanel, BorderLayout.CENTER);
		panel.add(scrollPane, BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createAttendancePanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout(0, 20));
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));

		JLabel titleLabel = new JLabel("Chấm công hôm nay");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		titleLabel.setForeground(new Color(31, 41, 55));

// Button panel với style sạch
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
		buttonPanel.setBackground(Color.WHITE);

		btnCheckIn = createModernButton("CHECK IN", new Color(34, 197, 94), new Color(22, 163, 74));
		btnCheckIn.setPreferredSize(new Dimension(180, 50));
		btnCheckIn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCheckIn.addActionListener(e -> {
			String time = java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
			JOptionPane.showMessageDialog(this, "Check in thành công lúc: " + time, "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		});

		btnCheckOut = createModernButton("CHECK OUT", new Color(239, 68, 68), new Color(220, 38, 38));
		btnCheckOut.setPreferredSize(new Dimension(180, 50));
		btnCheckOut.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCheckOut.addActionListener(e -> {
			String time = java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
			JOptionPane.showMessageDialog(this, "Check out thành công lúc: " + time, "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		});

		buttonPanel.add(btnCheckIn);
		buttonPanel.add(btnCheckOut);

// Bảng lịch sử chấm công
		String[] columns = { "Ngày", "Ca", "Check In", "Check Out", "Giờ làm", "OT", "Đi muộn", "Về sớm" };
		attendanceModel = new DefaultTableModel(columns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

// Thêm dữ liệu mẫu
		attendanceModel
				.addRow(new Object[] { "2025-10-21", "Ca sáng", "07:15", "12:00", "4.75h", "0h", "Có", "Không" });
		attendanceModel
				.addRow(new Object[] { "2025-10-20", "Ca chiều", "13:00", "18:30", "5.5h", "0.5h", "Không", "Không" });
		attendanceModel
				.addRow(new Object[] { "2025-10-19", "Ca sáng", "07:00", "12:00", "5h", "0h", "Không", "Không" });

		tblAttendance = createModernTable(attendanceModel);
		JScrollPane scrollPane = new JScrollPane(tblAttendance);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(229, 231, 235), 1));

		panel.add(titleLabel, BorderLayout.NORTH);
		panel.add(buttonPanel, BorderLayout.CENTER);
		panel.add(scrollPane, BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createSalaryPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout(0, 20));
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));

		JLabel titleLabel = new JLabel("Bảng lương tháng 10/2025");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		titleLabel.setForeground(new Color(31, 41, 55));

// Summary cards với grid đơn giản
		JPanel summaryPanel = new JPanel(new GridLayout(1, 3, 15, 0));
		summaryPanel.setBackground(Color.WHITE);
		summaryPanel.setBorder(new EmptyBorder(20, 0, 20, 0));

		summaryPanel.add(createSimpleCard("Tổng ca làm: 22 ca", new Color(59, 130, 246)));
		summaryPanel.add(createSimpleCard("Giờ OT: 15.5 giờ", new Color(16, 185, 129)));
		summaryPanel.add(createSimpleCard("Tổng lương: 15,500,000 VNĐ", new Color(239, 68, 68)));

// Chi tiết đơn giản
		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(Color.WHITE);
		detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
		detailPanel.setBorder(BorderFactory.createLineBorder(new Color(229, 231, 235), 1));

		JLabel detailTitle = new JLabel("Chi tiết");
		detailTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
		detailTitle.setForeground(new Color(31, 41, 55));
		detailTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		detailPanel.add(detailTitle);
		detailPanel.add(Box.createRigidArea(new Dimension(0, 15)));

		detailPanel.add(createDetailRow("Số ngày làm việc:", "22 ngày"));
		detailPanel.add(createDetailRow("Số giờ làm việc:", "176 giờ"));
		detailPanel.add(createDetailRow("Đi muộn:", "2 lần"));
		detailPanel.add(createDetailRow("Về sớm:", "1 lần"));
		detailPanel.add(createDetailRow("Nghỉ có phép:", "1 ngày"));
		detailPanel.add(createDetailRow("Trạng thái:", "Đã duyệt"));

		panel.add(titleLabel, BorderLayout.NORTH);
		panel.add(summaryPanel, BorderLayout.CENTER);
		panel.add(detailPanel, BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createSimpleCard(String text, Color color) {
		JPanel card = new JPanel();
		card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
		card.setBackground(color);
		card.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(color.darker(), 1),
				new EmptyBorder(15, 20, 15, 20)));

		JLabel lblText = new JLabel(text);
		lblText.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblText.setForeground(Color.WHITE);
		lblText.setAlignmentX(Component.CENTER_ALIGNMENT);

		card.add(lblText);

		return card;
	}

	private JPanel createDetailRow(String label, String value) {
		JPanel row = new JPanel(new BorderLayout());
		row.setBackground(Color.WHITE);
		row.setBorder(new EmptyBorder(8, 20, 8, 20));
		row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

		JLabel lblLabel = new JLabel(label);
		lblLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLabel.setForeground(new Color(75, 85, 99));

		JLabel lblValue = new JLabel(value);
		lblValue.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblValue.setForeground(new Color(31, 41, 55));

		row.add(lblLabel, BorderLayout.WEST);
		row.add(lblValue, BorderLayout.EAST);

		return row;
	}

// Modern Helper Methods
	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label.setForeground(new Color(55, 65, 81));
		return label;
	}

	private JTextField createModernTextField() {
		JTextField textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField.setPreferredSize(new Dimension(380, 40));
		textField.setBackground(new Color(249, 250, 251));
		textField.setForeground(new Color(31, 41, 55));
		textField.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
						BorderFactory.createEmptyBorder(8, 12, 8, 12)));

// Focus effect đơn giản
		textField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				textField.setBorder(
						BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(59, 130, 246), 2),
								BorderFactory.createEmptyBorder(7, 11, 7, 11)));
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				textField.setBorder(
						BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
								BorderFactory.createEmptyBorder(8, 12, 8, 12)));
			}
		});

		return textField;
	}

	private JComboBox<String> createModernComboBox(String[] items) {
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setPreferredSize(new Dimension(120, 40));
		comboBox.setBackground(new Color(249, 250, 251));
		comboBox.setForeground(new Color(31, 41, 55));
		comboBox.setBorder(BorderFactory.createLineBorder(new Color(209, 213, 219), 1));
		return comboBox;
	}

	private JButton createModernButton(String text, Color bgColor, Color hoverColor) {
		JButton button = new JButton(text);
		button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		button.setForeground(Color.WHITE);
		button.setBackground(bgColor);
		button.setPreferredSize(new Dimension(200, 45));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));

		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(hoverColor);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(bgColor);
			}
		});

		return button;
	}

	private JTable createModernTable(DefaultTableModel model) {
		JTable table = new JTable(model);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table.setRowHeight(40);
		table.setGridColor(new Color(229, 231, 235));
		table.setSelectionBackground(new Color(219, 234, 254));
		table.setSelectionForeground(new Color(31, 41, 55));
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);

// Header xanh nhẹ
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD, 13));
		header.setBackground(new Color(59, 130, 246));
		header.setForeground(Color.BLACK);
		header.setPreferredSize(new Dimension(0, 45));

// Center align
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		return table;
	}

	private String[] generateNumbers(int start, int end) {
		String[] numbers = new String[end - start + 1];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = String.valueOf(start + i);
		}
		return numbers;
	}

	private void btnLogoutClicked() {
		int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất?", "Xác nhận",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (choice == JOptionPane.YES_OPTION) {
			this.dispose();
			new Login().setVisible(true);
		}
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		java.awt.EventQueue.invokeLater(() -> {
			new Employees().setVisible(true);
		});
	}
}