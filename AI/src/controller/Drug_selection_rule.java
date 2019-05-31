/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author nguyen
 */
public class Drug_selection_rule {

    public ArrayList<String> drug_selection_rule(ArrayList<Double> X) {
        double probability_Fever = X.get(0);
        double probability_Malaria = X.get(1);
        double probability_Typhoid = X.get(2);
        double probability_Stomach = X.get(3);
        double probability_ChestProblem = X.get(4);
        ArrayList<String> drug_selection = new ArrayList<>();

        if (probability_Fever >= 0.5) {
            String data = "";
            if (probability_Fever < 0.65) {
                data = "Sốt vi rút hơi cao\n"
                        + "     - Hạ sốt bằng cách lau nước ấm. Dùng khăn thấm nước ấm và bắt đầu lau người theo chiều xuôi từ trên cánh tay xuống bàn tay, tương tự với lưng và chân cũng vậy\n"
                        + "     - Dùng tất ướt quấn quanh mắt cá chân : Ban đầu sẽ có cảm giác kos chịu một chút nhưng chỉ sau 10-15 phút bạn sẽ thấy thân nhiệt của mình mát mẻ trở lại\n"
                        + "     - Chườm đá hạ sốt : Bỏ đá lạnh vào chiếc khăn sạch hay có túi chườm lạnh sẽ tiện hơn. Chườm lên trán khoảng 5-10 phút bạn sẽ hạ sốt ngay tức thì\n"
                        + "     - Hạ sốt bằng chanh tươi : Dùng dao cắt chanh thành các lát mỏng theo chiều ngang (hình tròn của quả chanh) sau đó dùng miếng chanh chà sát vào chán, khuỷu tay và dọc xương sống, hiệu quả với cả sốt cao\n"
                        + "     - Lau mát hoặc đáp khoai tây\n\n";
            }else if((probability_Fever >= 0.65)&&(probability_Fever < 0.85)){
                data = "Sốt viruts khá cao\n"
                        + "     - Viên nén paracetamol 500mg: 2 viên 500mg uống mỗi 4-6 giờ với người lớn hoặc 1 viên  uống mỗi 4-6 giờ với trẻ em\n"
                        + "     - uống nhiều nước Kết hợp sử dụng dung các biện pháp như chườm đá, lau người bằng nước ấm, hạ sốt bằng chanh tươi\n\n"; 
            }else{
                data = "sốt virut rất cao\n"
                        + "     - Viên nén paracetamol 500mg: 2 viên 500mg uống mỗi 4-6 giờ với người lớn hoặc 1 viên  uống mỗi 4-6 giờ với trẻ em\n"
                        + "     - Truyền nước Sử dụng thêm dung dịch oserol, chườm đá, hạ sốt bằng chanh\n"
                        + "     - nếu sốt dùng các biện pháp trên nhiều ngày vẫn không khỏi thì nên đi bệnh viện\n\n";
            }
            drug_selection.add(data);
        }
        if(probability_Malaria >= 0.5){
            String data = "";
            if(probability_Malaria < 0.65){
                data ="Sốt rét hơi cao\n."
                        + "     - Sử dụng chanh tươi điều trị sốt rét\n"
                        + "     - Sử dụng nước ấm để điều trị bệnh sốt rét\n"
                        + "     - Sử dụng khoai tây để điều trị sốt rét\n\n";
            }else if((probability_Malaria >= 0.65)&&(probability_Malaria < 0.85)){
                data ="Sốt rét Khá cao :\n"
                        + "     - Sử dụng chanh tươi điều trị sốt rét\n"
                        + "     - Sử dụng nước ấm để điều trị bệnh sốt rét\n"
                        + "     - Sử dụng khoai tây để điều trị sốt rét\n"
                        + "     - Bạn nên cho người bệnh uống nhiều nước nước suối hoặc nước cam để ngăn ngừa tình trạng mất nước của cơ thể\n\n";
            }else{
                data ="Sốt rét rất cao ."
                        + "     - Sử dụng chanh tươi điều trị sốt rét\n"
                        + "     - Sử dụng nước ấm để điều trị bệnh sốt rét\n"
                        + "     - Sử dụng khoai tây để điều trị sốt rét\n"
                        + "     - Nếu trường hợp bệnh nhân không hạ sốt, có dấu hiệu co giật thì bạn nên đưa người bệnh đến bệnh viện ngay lập tức\n\n";
            }
            drug_selection.add(data);
        }
        
        if(probability_Typhoid >= 0.5){
            String data = "Thương hàn : \n"
                    + "     - Đánh gió: Dầu nóng hoặc một củ gừng tươi\n."
                    + "     - Xông hơi: Lá sả, lá tre, lá bưởi, lá cúc tần, lá kinh giới, lá ngải cứu, mỗi thứ một nắm nhỏ (các loại lá này đều chứa tinh dầu cay nóng).\n"
                    + "     - Cháo giải cảm: Cháo thịt nạc hoặc cháo trứng, thái thêm một ít lá tía tô, hành, kinh giới, gừng tươi ăn nóng. Các dược liệu trên đều có chứa tinh dầu, vì thế khi ăn nên tranh thủ hít hơi nóng bốc lên từ tô cháo càng nhiều càng tốt, bởi vì tô cháo cũng có cả tác dụng như một nồi xông nhỏ.\n\n";
            drug_selection.add(data);
        }

        if(probability_Stomach >= 0.5){
            String data = "Bệnh dạ dày:\n"
                    + "     - Tinh bột nghệ chữa đau dạ dày\n"
                    + "     - Mật ong thần dược đa năng chữa đau dạ dày\n"
                    + "     - Chữa đau dạ dày bằng lá cây tía tô\n\n";
            drug_selection.add(data);
        }
        
        if(probability_ChestProblem >=0.5){
            String data = "Bệnh về tim:\n"
                    + "      - Bạn có vấn đề về ở vùng ngực hoặc tim mạch, đây là triệu chứng nguy hiểm, cần đi khám bác sỹ\n\n";
            drug_selection.add(data);
        }
        return drug_selection;

    }

}
