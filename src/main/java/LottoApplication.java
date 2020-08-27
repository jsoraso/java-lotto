import step2.domain.*;
import step2.domain.view.InputView;
import step2.domain.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputMoney = inputView.inputMoney();

        int lottoCount = LottoMachine.getCount(inputMoney);
        Lottos lottos = Lotto.create(lottoCount);

        OutputView outputView = new OutputView();
        outputView.viewLottoNumbers(lottos);

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.inputWinningNumbers());
        LottoResult lottoResult = lottos.getMatching(winningLottoNumbers);

        outputView.viewResult(lottoResult, inputMoney);

    }
}
