package woo.app.lookups;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

/**
 * Lookup products cheaper than a given price.
 */
public class DoLookupProductsUnderTopPrice extends Command<Storefront> {

  private Input<Integer> _price;

  public DoLookupProductsUnderTopPrice(Storefront storefront) {
    super(Label.PRODUCTS_UNDER_PRICE, storefront);
    _price = _form.addIntegerInput(Message.requestPriceLimit());

  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    _display.addLine(_receiver.getStore().showProductsUnderTopPrice(_price.value()));
    _display.display();
  }
}
