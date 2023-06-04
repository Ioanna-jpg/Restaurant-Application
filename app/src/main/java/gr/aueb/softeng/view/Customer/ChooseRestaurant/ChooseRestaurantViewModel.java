package gr.aueb.softeng.view.Customer.ChooseRestaurant;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;


public class ChooseRestaurantViewModel extends ViewModel {
    ChooseRestaurantPresenter presenter;

    public ChooseRestaurantViewModel()
    {
        presenter = new ChooseRestaurantPresenter(new RestaurantDAOmemory());
    }

    public ChooseRestaurantPresenter getPresenter() {
        return presenter;
    }
}