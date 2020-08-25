package step2.domain.view;

import step2.domain.LottoMatchingCount;
import step2.domain.LottoTicket;
import step2.domain.LottoNumbers;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void viewLottoNumbers(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getLottoNumbersList().size() + "개를 구매했습니다.");
        lottoTicket.getLottoNumbersList().stream()
                .map(LottoNumbers::getLottoNumbers)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void viewResult(Map<Integer, Long> resultMap, String lottoMoney) {
        int margin = 0;
        for(int i = 3; i <= 6; i++) {
            int getCountAtResultMap = Math.toIntExact(resultMap.getOrDefault(i, 0L));
            int money = LottoMatchingCount.toLottoMatchingCount(i).getMoney();
            margin += money * getCountAtResultMap;
            System.out.println(i + "개 일치 (" + money + "원) - " + getCountAtResultMap + "개");

        }
        double marginPercent = Math.round( (double)margin / Double.parseDouble(lottoMoney) * 100) / 100.0 ;
        System.out.println("총 수익률은" + marginPercent + "입니다.");

    }
}
