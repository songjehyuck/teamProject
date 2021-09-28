package bookbooking;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;


public class ControllerLibrary implements Initializable{

    @FXML
    private StackPane stack1;

    @FXML
    private StackPane stack2;

    @FXML
    private StackPane stack3;
    
    @FXML
    private Button btn_msearch;

    @FXML
    private Button btn_mrent;

    @FXML
    private Button btn_myinfo;

    @FXML
    private Label bookName_sub;

    @FXML
    private Label origin_sub;

    @FXML
    private Label Author_sub;

    @FXML
    private Label age_sub;

    @FXML
    private Label slb_bookState;

    @FXML
    private DatePicker slb_bookRentalDate;

    @FXML
    private Label slb_bookReturnDate;

    @FXML
    private TextArea slb_bookContent;
    
    @FXML
    private ComboBox cbox_category;
   
    @FXML
    private TextField box_Search;
    
    @FXML
    private TableView<BookItem> frm_bookSearch;
    
    @FXML
    private TableView<BookItem> frm_bookRental;
    
    @FXML
    private Button btn_Rental;
    
    @FXML
    private Button btn_rentalCancel;
    
    @FXML
    private Button btn_Logout;
    
    MemberDTO userInfo;

    private TableColumn<BookItem, String> title = new TableColumn<>("책 이름");
    private TableColumn<BookItem, String> Original = new TableColumn<>("원제");
    private TableColumn<BookItem, String> author = new TableColumn<>("저자");
    private TableColumn<BookItem, String> Age = new TableColumn<>("발행년도");
    private TableColumn<BookItem, String> rental_state = new TableColumn<>("대여 정보");
    
	private TableColumn<BookItem, String> m2_title = new TableColumn<>("책 이름");
	private TableColumn<BookItem, String> m2_Original = new TableColumn<>("원제");
	private TableColumn<BookItem, String> m2_author = new TableColumn<>("저자");
	private TableColumn<BookItem, String> m2_Age = new TableColumn<>("발행년도");
	private TableColumn<BookItem, String> m2_rental_state = new TableColumn<>("대여 상태");
	private TableColumn<BookItem, String> m2_rental_day = new TableColumn<>("대여 날짜");
	private TableColumn<BookItem, String> m2_return_day= new TableColumn<>("반납 날짜");
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
		stackPaneStyleCode();
		iniBookViewer();

		try {
			
			
			frm_bookSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
	
				@Override
				public void handle(Event event) {
					// TODO Auto-generated method stub
					
					String tmpBookName = frm_bookSearch.getSelectionModel().getSelectedItem().getRental_state();
					
					if ( !tmpBookName.equals("예약 가능") ) {
						slb_bookRentalDate.setDisable(true);
						btn_Rental.setDisable(true);
					}else {
						slb_bookRentalDate.setDisable(false);
						btn_Rental.setDisable(false);
					}
					for ( int i = 0; i < Main.item.length; i++ ) {
						if ( Main.item[i].getTitle().equals(frm_bookSearch.getSelectionModel().getSelectedItem().getTitle())) {
							bookName_sub.setText(Main.item[i].getTitle());
							origin_sub.setText(Main.item[i].getOriginal());
							Author_sub.setText(Main.item[i].getAuthor());
							age_sub.setText(Main.item[i].getAge());
							slb_bookContent.setText(Main.item[i].getContent());
							slb_bookState.setText(Main.item[i].getRental_state());				
							break;
						}else {
							continue;
						}
					}
				}
				
			});
		}catch(Exception e) {}
		
		
		ObservableList<BookItem> list = getSearchTable();
		
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		Original.setCellValueFactory(new PropertyValueFactory<>("Original"));
		author.setCellValueFactory(new PropertyValueFactory<>("author"));
		Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
		rental_state.setCellValueFactory(new PropertyValueFactory<>("rental_state"));
		
		frm_bookSearch.setItems(list);
		colorMainColum();
		
		 
		frm_bookSearch.requestFocus();
		frm_bookSearch.getSelectionModel().select(0);
		frm_bookSearch.getFocusModel().focus(0);
		
		
		
		slb_bookRentalDate.valueProperty().addListener(new ChangeListener<LocalDate>() {

			@Override
			public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue,
					LocalDate newValue) {
				
				String localDate = String.valueOf(newValue);
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					
					Date date = df.parse(localDate);
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					cal.add(Calendar.DATE, 5);
					
					slb_bookReturnDate.setText(df.format(cal.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		ObservableList<String> options = FXCollections.observableArrayList(
				"책 제목",
				"원제",
				"저자",
				"발행년도"
				);
		
		cbox_category.setItems(options);
	}
	
	
	private ObservableList<BookItem> getSearchTable(){
		
		ObservableList<BookItem> list = FXCollections.observableArrayList();
		for( int i = 0; i < Main.item.length; i++ ) {
				list.add(Main.item[i]);
		}
		
		return list;
	}
	

    @FXML
    void openSearch(ActionEvent event) {
    	stack1.setVisible(true);
    	stack2.setVisible(false);
    	
    	try {
	    	ObservableList<BookItem> list = getSearchTable();
	
			title.setCellValueFactory(new PropertyValueFactory<>("title"));
			Original.setCellValueFactory(new PropertyValueFactory<>("Original"));
			author.setCellValueFactory(new PropertyValueFactory<>("author"));
			Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
			rental_state.setCellValueFactory(new PropertyValueFactory<>("rental_state"));
			
			frm_bookSearch.getItems().clear();
			frm_bookSearch.setItems(list);
			colorMainColum();
    	}catch(Exception e) {}
    }
    
 
    @FXML
    void searchBook(ActionEvent event) {
    	
    	ObservableList<BookItem> list = FXCollections.observableArrayList();
    	String getCateVal = String.valueOf(cbox_category.getValue());
    	String getBoxVal  = box_Search.getText();
    	
    	if ( cbox_category.getValue() == null || getCateVal.isEmpty() ) {
    		Main.showAlert("검색 카테고리를 선택해주세요.");
    		return;
    	}
    	
    	if ( getBoxVal == null || getBoxVal.isEmpty() ) {
    		openSearch(event);
    		return;
    	}
    	
    	
    	if ( getCateVal.equals("책 제목") ) {

    		for ( int i = 0; i < Main.item.length; i++ ) {
        		if ( Main.item[i].getTitle().contains(getBoxVal) ) {
        			list.add(Main.item[i]);
        		}
        	}
    		
    	}else if ( getCateVal.equals("원제") ) {
    		for ( int i = 0; i < Main.item.length; i++ ) {
        		if ( Main.item[i].getOriginal().contains(getBoxVal)) {
        			list.add(Main.item[i]);
        		}
        	}
    	}else if ( getCateVal.equals("저자") ) {
    		for ( int i = 0; i < Main.item.length; i++ ) {
        		if ( getBoxVal.equals(Main.item[i].getAuthor())) {
        			list.add(Main.item[i]);
        		}
        	}
    	}else if ( getCateVal.equals("발행년도") ) {
    		for ( int i = 0; i < Main.item.length; i++ ) {
        		if ( getBoxVal.equals(Main.item[i].getAge())) {
        			list.add(Main.item[i]);
        		}
        	}
    	}
    	
		frm_bookSearch.getItems().clear();
		frm_bookSearch.setItems(list);
		tableFisrtBook();
		colorMainColum();
	
    }
    
    
    void colorMainColum() {
    	rental_state.setCellFactory(new Callback<TableColumn<BookItem, String>, TableCell<BookItem, String>>() {
            @Override
            public TableCell<BookItem, String> call(TableColumn<BookItem, String> param) {
                return new TableCell<BookItem, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            this.setTextFill(Color.GREEN);
                           
                            if(item.contains("예약 중")) 
                                this.setTextFill(Color.RED);
                            
                            if(item.contains("대여 중")) 
                                this.setTextFill(Color.BLUE);
                            
                            
                            setText(item);
                        }
                    }

                };
            }
        });
    }
    
   
	private ObservableList<BookItem> getRentalTable(String userId){
		ObservableList<BookItem> list = FXCollections.observableArrayList();

		try {
			for( int i = 0; i < Main.item.length; i++ ) {
				if ( userId.equals(Main.item[i].getuserId()) ) {
					list.add(Main.item[i]);
				}
			}
			
		}catch (Exception e) {}

		if (list == null || list.isEmpty()) {
			list = null;
		}
		return list;
	}

    
	
    @FXML
    void openRent(ActionEvent event) {
    	
    	ObservableList<BookItem> list = getRentalTable(userInfo.getId());
    	if ( list == null ) {
    		Main.showAlert("대여 중인 책이 없습니다.");
    		return;
    	}
    	stack1.setVisible(false);
    	stack2.setVisible(true);
	
    	
		m2_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		m2_Original.setCellValueFactory(new PropertyValueFactory<>("Original"));
		m2_author.setCellValueFactory(new PropertyValueFactory<>("author"));
		m2_Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
		m2_rental_state.setCellValueFactory(new PropertyValueFactory<>("rental_state"));
		m2_rental_day.setCellValueFactory(new PropertyValueFactory<>("rental_day"));
		m2_return_day.setCellValueFactory(new PropertyValueFactory<>("return_day"));
		
		m2_rental_state.setCellFactory(new Callback<TableColumn<BookItem, String>, TableCell<BookItem, String>>() {
	            @Override
	            public TableCell<BookItem, String> call(TableColumn<BookItem, String> param) {
	                return new TableCell<BookItem, String>() {

	                    @Override
	                    public void updateItem(String item, boolean empty) {
	                        super.updateItem(item, empty);
	                        if (!isEmpty()) {
	                            this.setTextFill(Color.RED);
	                        
	                            if(item.contains("반납 완료")) 
	                                this.setTextFill(Color.GREEN);
	                            
	                            if(item.contains("연체")) 
	                                this.setTextFill(Color.BLUE);
	                            
	                            if(item.contains("예약 취소")) 
	                                this.setTextFill(Color.GRAY);
	                            
	                            setText(item);
	                        }
	                    }

	                };
	            }
	        });
		
		frm_bookRental.setItems(list);
    }
    
    @FXML
    void openMyinfo(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("modifyFrm.fxml"));
		loader.setController(new ControllerModify());
		Parent root = (Parent)loader.load();
		
		
		ControllerModify controller = loader.<ControllerModify>getController();
		//controller.initData(userInfo);
				
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Library Member Modify");
		primaryStage.setScene(scene);
		primaryStage.show();
		
    }

    @FXML
    void closeLogout(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFrm.fxml"));
		loader.setController(new ControllerLibrary());
		Parent root = (Parent)loader.load();
				
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		((Node) event.getSource()).getScene().getWindow().hide();
    }

	
    @FXML
    void sendRental(ActionEvent event) {

    	BookItem tempItem = null;

    	LocalDate today = LocalDate.now();
    	LocalDate rentalDate = slb_bookRentalDate.getValue();

    	if ( slb_bookState.getText().equals("예약 가능")) {
    		
    		boolean bookRentalFlag = false;
    		
    		for ( int i = 0; i < frm_bookSearch.getItems().size(); i++ ) {
        		if ( bookName_sub.getText().equals(frm_bookSearch.getItems().get(i).getTitle()) ) {
        			bookRentalFlag = true;
        			break;
        		}
        	}
    		if ( !bookRentalFlag ) {
    			Main.showAlert("도서 검색 목록에 없는 책입니다. \n\n책을 선택 해주세요.");
    			return;
    		}
    		
        	if ( rentalDate == null || rentalDate.isBefore(today)) {
        		Main.showAlert("대여 날짜를 확인 해주세요.");
        		return;
        	}
        	
    		for ( int i = 0 ; i < Main.item.length; i++ ) {
    			if ( Main.item[i].getTitle().equals(bookName_sub.getText()) ) {
    				
    				Alert alert = new Alert(AlertType.CONFIRMATION, "'"+bookName_sub.getText()+"' 선택하신 도서가 맞습니까?", ButtonType.YES, ButtonType.NO);
    		    	alert.setTitle("알림");
    		    	alert.setHeaderText(null);
    		    	alert.showAndWait();

    		    	if (alert.getResult() == ButtonType.YES) {
    		    		Main.item[i].setRental_day(String.valueOf(slb_bookRentalDate.getValue()));
    		    		Main.item[i].setReturn_day(slb_bookReturnDate.getText());
    		    		Main.item[i].setRental_state("예약 중");
    		    		Main.item[i].setuserId(userInfo.getId());
        				Main.showAlert("예약 되었습니다.");
        				
        				slb_bookState.setText("예약 중");
        				slb_bookRentalDate.setValue(null);
        				slb_bookRentalDate.setDisable(true);
        				btn_Rental.setDisable(true);
        				
        				openSearch(event);
    		    	}
    				
    				break;
    			}else {
    				continue;
    			}
    		}
    	}else {
    		Main.showAlert("예약 불가능한 도서입니다.");
    	}
    	
    }
    
   
    void stackPaneStyleCode() {
    
		title.setStyle("-fx-alignment: CENTER;");
		Original.setStyle("-fx-alignment: CENTER;");
		author.setStyle("-fx-alignment: CENTER;");	
		Age.setStyle("-fx-alignment: CENTER;");
		rental_state.setStyle("-fx-alignment: CENTER;");
		
		frm_bookSearch.setStyle("-fx-selection-bar: #ddd; -fx-selection-bar-non-focused: #ccc;");
		frm_bookSearch.getColumns().addAll(title, Original, author, Age, rental_state);
		
		
    	m2_title.setStyle("-fx-alignment: CENTER;");
		m2_Original.setStyle("-fx-alignment: CENTER;");
		m2_author.setStyle("-fx-alignment: CENTER;");
		m2_Age.setStyle("-fx-alignment: CENTER;");
		m2_rental_day.setStyle("-fx-alignment: CENTER;");
		m2_return_day.setStyle("-fx-alignment: CENTER;");
		m2_rental_state.setStyle("-fx-alignment: CENTER;");
		
		frm_bookRental.getColumns().addAll(m2_title, m2_Original, m2_author, m2_Age, m2_rental_state, m2_rental_day, m2_return_day );
		
    }
    
    
    void iniBookViewer() {
    	
		String bookName 	 = Main.item[0].getTitle();
		String bookOriginal = Main.item[0].getOriginal();
		String bookAuthor	 = Main.item[0].getAuthor();
		String bookAge	 = Main.item[0].getAge();
		String bookState 	 = Main.item[0].getRental_state();
		String bookContent   = Main.item[0].getContent();
		
		bookName_sub.setText(bookName);
		origin_sub.setText(bookOriginal);
		Author_sub.setText(bookAuthor);
		age_sub.setText(bookAge);
		slb_bookContent.setText(bookContent);
		slb_bookState.setText(bookState);
    }
  
  
   void tableFisrtBook() {

	   try {
		  
	   	String bookName 	 = frm_bookSearch.getItems().get(0).getTitle();
		String bookOriginal = frm_bookSearch.getItems().get(0).getOriginal();
		String bookAuthor	 = frm_bookSearch.getItems().get(0).getAuthor();
		String bookAge	 = frm_bookSearch.getItems().get(0).getAge();
		String bookState 	 = frm_bookSearch.getItems().get(0).getRental_state();
		String bookContent   = frm_bookSearch.getItems().get(0).getContent();
		
		bookName_sub.setText(bookName);
		origin_sub.setText(bookOriginal);
		Author_sub.setText(bookAuthor);
		age_sub.setText(bookAge);
		slb_bookContent.setText(bookContent);
		slb_bookState.setText(bookState);
	   
	   }catch(Exception e) {}
   }

  
   @FXML
   void rentalCancel(ActionEvent event) {
	   
	   try {

		   BookItem selectBook = frm_bookRental.getSelectionModel().getSelectedItem();

		   if ( selectBook != null && selectBook.getRental_state().equals("예약 중")){
			
			   Alert alert = new Alert(AlertType.CONFIRMATION, "'"+selectBook.getTitle()+"' 선택하신 도서가 맞습니까?", ButtonType.YES, ButtonType.NO);
			   alert.setTitle("알림");
			   alert.setHeaderText(null);
			   alert.showAndWait();
	
		    	if (alert.getResult() == ButtonType.YES) {
		    		
		    			
		    			for ( int i = 0; i < Main.item.length; i++) {
		    				if ( selectBook.getTitle().equals(Main.item[i].getTitle())) {
		    					Main.item[i].setuserId(null);
		    					Main.item[i].setRental_day(null);
		    					Main.item[i].setReturn_day(null);
		    					Main.item[i].setRental_state("예약 가능");
		    					break;
		    				}
		    			}
		    		
		    			Main.showAlert("취소 되었습니다.");
		    		
		    			ObservableList<BookItem> list = getRentalTable(userInfo.getId());
		    	    	if ( list == null ) {
			    			openSearch(event);
		    	    	}else {
		    	    		openRent(event);
		    	    	}
		    	    	
		    			
		    	}
		   }else {
			   Main.showAlert("책을 선택 해주세요.");
		   }
	   }catch(Exception e) {}
	   
   }

   
   void initData(MemberDTO mb_item) {
   	this.userInfo = mb_item;
   }
  
}
