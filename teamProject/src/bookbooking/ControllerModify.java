package bookbooking;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * ȸ������ ���� ȭ�� 
 * 
 * ��� : ȸ�� ���� ���� ( ��й�ȣ, �а�, ��ȭ��ȣ )
 */
public class ControllerModify implements Initializable{
    @FXML
    private PasswordField m_pw;

    @FXML
    private PasswordField m_repw;

    @FXML
    private PasswordField m_repw2;

    @FXML
    private TextField m_dpName;

    @FXML
    private Label m_id;

    @FXML
    private Label m_name;

    @FXML
    private Label m_stnum;

    @FXML
    private TextField m_ph1;

    @FXML
    private TextField m_ph2;

    @FXML
    private TextField m_ph3;

    @FXML
    private Button btn_modify;

    MemberDTO userInfo;
    
    void initData(MemberDTO mb_item) {
	   	this.userInfo = mb_item;
	   	m_id.setText(userInfo.getId());
		m_name.setText(userInfo.getPwd());
		m_dpName.setText(userInfo.getappo_list());
		
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	

		
	}
   
	boolean pwChangeFlag = false;
	@FXML
    void modifyOK(ActionEvent event) {
			
		if ( m_pw.getText() == null || m_pw.getText().trim().isEmpty()) {
			Main.showAlert("password를 채워주세요.");
			return;
		}
		
		if ( !m_pw.getText().equals(userInfo.getPwd())){
			Main.showAlert(".");
			return;
		}
	
		if ( (m_repw.getText() == null && m_repw.getText().trim().isEmpty())
				|| (m_repw2.getText() == null && m_repw2.getText().trim().isEmpty()) ) {
			Main.showAlert("�����Ͻ� ��й�ȣ�� Ȯ�����ּ���.");
			return;
		}else {
			if ( !m_repw.getText().equals(m_repw2.getText())) {
				Main.showAlert("������ ��й�ȣ�� ���� ��ġ���� �ʽ��ϴ�.");
				return;
			}else {
				if ( !m_repw.getText().trim().isEmpty() && !m_repw2.getText().trim().isEmpty()) {
					
					pwChangeFlag = true;
				}
			}
		}
	
		if ( m_dpName.getText() == null || m_dpName.getText().trim().isEmpty()) {
			Main.showAlert("�а��� �Է����ּ���.");
			return;
		}
		if ( !Main.isStringDouble(m_ph1.getText()) || !Main.isStringDouble(m_ph2.getText()) || !Main.isStringDouble(m_ph3.getText()) ) {
			Main.showAlert("�ڵ��� ��ȣ�� ���ڸ� �Է� ���ּ���. ");
			return;
		}
		
		
		if ( pwChangeFlag ) {
			userInfo.setPwd(m_repw.getText());
		}
		
		Main.showAlert("ȸ�������� �����Ǿ����ϴ�.");
		
		((Node) event.getSource()).getScene().getWindow().hide();
    }


}
