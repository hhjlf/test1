package asd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CustomerControl implements Initializable {
	private static final Event MouseEvent = null;
	@FXML
	TextField name;
	@FXML
	TextField wnals1;
	@FXML
	TextField wnals2;
	@FXML
	TextField tel1;
	@FXML
	TextField tel2;
	@FXML
	TextField tel3;
	@FXML
	RadioButton men;
	@FXML
	RadioButton girl;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private CheckBox ck1;
	@FXML
	private CheckBox ck2;
	@FXML
	private CheckBox ck3;
	@FXML
	private CheckBox ck4;
	@FXML
	private CheckBox ck5;
	@FXML
	private ListView view;
	@FXML
	private TextArea info;
	@FXML
	private MenuItem exit;
	@FXML
	private MenuItem save;
	@FXML
	private MenuItem com;
	ObservableList<CustomerVO> V = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ListView();
		
		save.setOnAction(event -> {
			try {
				saveClick(MouseEvent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		view.setOnMouseClicked(event -> {
			try {
				viewClick(MouseEvent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		btn1.setOnAction(event -> {
			try {
				Btn1(event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btn2.setOnAction(event -> {
			try {
				Btn2(event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btn3.setOnAction(event -> {
			try {
				Btn3(event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btn4.setOnAction(event -> {
			try {
				Btn4(event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btn5.setOnAction(event -> {
			try {
				Btn5(event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		wnals1.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (wnals1.getText().trim().length() > 6) {
					wnals1.setText(oldValue);
				}
			}
		});
		wnals2.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (wnals2.getText().trim().length() > 7) {
					wnals2.setText(oldValue);
				}
			}
		});
		tel1.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (tel1.getText().trim().length() > 3) {
					tel1.setText(oldValue);
				}
			}
		});
		tel2.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (tel2.getText().trim().length() > 4) {
					tel2.setText(oldValue);
				}
			}
		});
		tel3.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (tel3.getText().trim().length() > 4) {
					tel3.setText(oldValue);
				}
			}
		});

	}
public void saveClick (Event e) {
	 
}
	public void Btn4(ActionEvent e) {
		CustomerDAO dao = CustomerDAO.getInstance();
		String jumin = wnals1.getText().trim() + "-" + wnals2.getText().trim();
		dao.Delete(jumin);
		clear(true);
		ListView();
		info.clear();
	}

	public void Btn3(ActionEvent e) {
info.clear();
		int x = 0;
		ToggleGroup gender = new ToggleGroup();
		men.setToggleGroup(gender);
		men.setUserData("남자");
		girl.setToggleGroup(gender);
		girl.setUserData("여자");
		String nameval = name.getText();
		String jumin = wnals1.getText().trim() + "-" + wnals2.getText().trim();
		String tel = tel1.getText() + "-" + tel2.getText() + "-" + tel3.getText();
		String genderval = gender.getSelectedToggle().getUserData().toString();

		StringBuffer hobby = new StringBuffer();
		if (ck1.isSelected()) {
			hobby.append(ck1.getText() + ",");
		}
		if (ck2.isSelected()) {
			hobby.append(ck2.getText() + ",");
		}
		if (ck3.isSelected()) {
			hobby.append(ck3.getText() + ",");
		}
		if (ck4.isSelected()) {
			hobby.append(ck4.getText() + ",");
		}
		if (ck5.isSelected()) {
			hobby.append(ck5.getText());
		}
		CustomerDAO dao = CustomerDAO.getInstance();
		x = dao.Update(nameval, jumin, tel, genderval, hobby);
		ListView();
	}

	public void Btn5(ActionEvent c) {
		clear(true);
		info.clear();
		btn1.setDisable(false);
		btn2.setDisable(true);
		btn3.setDisable(true);
		btn4.setDisable(true);
		btn5.setDisable(true);
		view.setDisable(true);
		
	}

	public void Btn2(ActionEvent b) {
		info.clear();
		CustomerVO a = (CustomerVO) view.getSelectionModel().getSelectedItem();
		int year = 0;
		StringBuffer S = new StringBuffer();

		String jumin = wnals1.getText() + wnals2.getText();

		S.append(jumin);

		if (S.charAt(6) - 48 == 1 || S.charAt(6) - 48 == 2) {
			year = 1900;
		}
		if (S.charAt(6) - 48 == 3 || S.charAt(6) - 48 == 4) {
			year = 2000;
		}
		if (S.charAt(6) - 48 == 9 || S.charAt(6) - 48 == 0) {
			year = 1800;
		}

		year += (S.charAt(0) - 48) * 10 + S.charAt(1) - 48;
		String month = jumin.substring(2, 4);
		String day = jumin.substring(4, 6);

		info.appendText("분석결과\n\n");
		info.appendText("이 름 :" + a.getName() + "\n");
		info.appendText("나 이 :" + year + "년" + "\t" + month + "월" + "\t" + day + "일\n");
		info.appendText("전화번호" +a.getTel()+"\n");
		if (S.charAt(6) - 48 == 1 || S.charAt(6) - 48 == 3 || S.charAt(6) - 48 == 5 || S.charAt(6) - 48 == 9) {
			info.appendText("성 별 : 남자");
		} else {
			info.appendText("성 별 : 여자");
		}
		

	}

	public void Btn1(ActionEvent a) {
		try {
		info.clear();
		ToggleGroup gender = new ToggleGroup();
		men.setToggleGroup(gender);
		men.setUserData("남자");
		girl.setToggleGroup(gender);
		girl.setUserData("여자");
		String nameval = name.getText();
		String jumin = wnals1.getText().trim() + "-" + wnals2.getText().trim();
		String tel = tel1.getText() + "-" + tel2.getText() + "-" + tel3.getText();
		String genderval = gender.getSelectedToggle().getUserData().toString();

		StringBuffer hobby = new StringBuffer();
		if (ck1.isSelected()) {
			hobby.append(ck1.getText() + ",");
		}
		if (ck2.isSelected()) {
			hobby.append(ck2.getText() + ",");
		}
		if (ck3.isSelected()) {
			hobby.append(ck3.getText() + ",");
		}
		if (ck4.isSelected()) {
			hobby.append(ck4.getText() + ",");
		}
		if (ck5.isSelected()) {
			hobby.append(ck5.getText());
		}
		
		if (wnalsghkrdls(jumin) == 1) {
			
			CustomerDAO dao = CustomerDAO.getInstance();
			int x = dao.Insert(nameval, jumin, tel, genderval, hobby);
			if(x ==1) {
				clear(false);
				btn1.setDisable(true);
				btn2.setDisable(false);
				btn3.setDisable(false);
				btn4.setDisable(false);
				btn5.setDisable(false);
				view.setDisable(false);
			}else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("오류");
				alert.setHeaderText("회원가입실패");
				alert.setContentText("정확히입력해주세요");
				alert.showAndWait();
			}
		
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류");
			alert.setHeaderText("주민번호오류");
			alert.setContentText("정확한 주민번호를 입력하세요");
			alert.showAndWait();
		}
		
		
		ListView();
	}catch(Exception e) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("오류");
		alert.setHeaderText("회원가입실패");
		alert.setContentText("빈칸없이 입력하세여");
		alert.showAndWait();
	}
	}

	public int wnalsghkrdls(String jumin) {
		jumin =jumin.replaceAll("-","");
		
		int x = -1;
		int[] checkNum = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };

		int sum = 0;
		for (int i = 0; i < checkNum.length; i++) {
			int temp = (jumin.charAt(i) - 48) * checkNum[i];
			sum += temp;
		}
		int a = 11 - (sum % 11);
		if(a>=10) {
			a= a-10;
		}
		if ((jumin.charAt(12) - 48 == a)) {
			x = 1;
			
		} else {
			x = -1;

		}

		return x;
	}

	public void clear(boolean state) {

		name.clear();
		name.setDisable(!state);
		wnals1.clear();
		wnals1.setDisable(!state);
		wnals2.clear();
		wnals2.setDisable(!state);
		men.setDisable(!state);
		girl.setDisable(!state);
		tel1.clear();
		tel1.setDisable(!state);
		tel2.clear();
		tel2.setDisable(!state);
		tel3.clear();
		tel3.setDisable(!state);

		ck1.setSelected(false);
		ck2.setSelected(false);
		ck3.setSelected(false);
		ck4.setSelected(false);
		ck5.setSelected(false);

		ck1.setDisable(!state);
		ck2.setDisable(!state);
		ck3.setDisable(!state);
		ck4.setDisable(!state);
		ck5.setDisable(!state);
	}

	public void ListView() {

		CustomerDAO dao = CustomerDAO.getInstance();
		V = dao.getCustomer();
		view.setItems(V);

	}

	public void viewClick(Event e) {
		
			
		
		try {
		clear(true);
		
		CustomerVO a = (CustomerVO) view.getSelectionModel().getSelectedItem();
		name.setText(a.getName());
		StringTokenizer wn = new StringTokenizer(a.getWnals(), "-");
		StringTokenizer te = new StringTokenizer(a.getTel(), "-");
		wnals1.setText(wn.nextToken());
		wnals2.setText(wn.nextToken());
		tel1.setText(te.nextToken());
		tel2.setText(te.nextToken());
		tel3.setText(te.nextToken());
		if (a.getGneder().equals("남자".trim())) {
			men.setSelected(true);
		} else {
			girl.setSelected(true);
		}

		StringTokenizer ho = new StringTokenizer(a.getHobby(), ",");

		for (int i = 0; i < 5; i++) {
			
				String hoo = ho.nextToken();

				if (hoo.equals("게임")) {
					ck1.setSelected(true);
				}
				if (hoo.equals("영화")) {
					ck2.setSelected(true);
				}
				if (hoo.equals("운동")) {
					ck3.setSelected(true);
				}
				if (hoo.equals("독서")) {
					ck4.setSelected(true);
				}
				if (hoo.equals("음악")) {
					ck5.setSelected(true);
				}

			}
			}catch (Exception e1) {
		} 
	
}

	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/save.txt");
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	}
}