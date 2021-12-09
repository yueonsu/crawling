import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        String url = "https://www.melon.com/chart/index.htm";
        Document doc = Jsoup.connect(url).get();
        Elements titles = doc.select("div.ellipsis.rank01>span>a");
        Elements writers = doc.select("div.ellipsis.rank02>span");

        for(int i=0; i<titles.size(); i++) {
            MelonVO vo = new MelonVO();
            vo.setSinger(writers.get(i).text());
            vo.setSong(titles.get(i).text());
            MelonDAO.insBoard(vo);
        }
        System.out.println("끝");
    }
}
