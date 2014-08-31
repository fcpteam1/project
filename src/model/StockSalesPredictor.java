package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class StockSalesPredictor {

	Calendar calendar;
	Calendar today, yesterday, twoDaysAgo, threeDaysAgo, fourDaysAgo,
			fiveDaysAgo, sixDaysAgo;
	Calendar lastWeek, twoWeeksAgo, threeWeeksAgo;
	Calendar lastMonth, twoMonthsAgo, threeMonthsAgo;
	Calendar thisWeekLastYear, lastWeekLastYear, nextWeekLastYear;
	Calendar thisMonthLastYear, lastMonthLastYear, nextMonthLastYear;

	double thisWeekSales, lastWeekSales, twoWeekSales, threeWeekSales;
	double thisMonthSales, lastMonthSales, twoMonthSales, threeMonthSales;
	double thisWeekLastYearSales, lastWeekLastYearSales, nextWeekLastYearSales;
	double thisMonthLastYearSales, lastMonthLastYearSales,
			nextMonthLastYearSales;

	double nextWeekSales, nextMonthSales;

	double thisWeekStockSales, lastWeekStockSales, twoWeekStockSales,
			threeWeekStockSales;
	double thisMonthStockSales, lastMonthStockSales, twoMonthStockSales,
			threeMonthStockSales;
	double thisWeekLastYearStockSales, lastWeekLastYearStockSales,
			nextWeekLastYearStockSales;
	double thisMonthLastYearStockSales, lastMonthLastYearStockSales,
			nextMonthLastYearStockSales;

	double nextWeekStockSales, nextMonthStockSales;

	public StockSalesPredictor(ArrayList<Sale> sales) {
		// TODO Auto-generated constructor stub
		salesPredictor(sales);
	}

	public void salesPredictor(ArrayList<Sale> sales) {

		thisWeekSales = 0;
		lastWeekSales = 0;
		twoWeekSales = 0;
		threeWeekSales = 0;
		thisMonthSales = 0;
		lastMonthSales = 0;
		twoMonthSales = 0;
		threeMonthSales = 0;
		thisWeekLastYearSales = 0;
		lastWeekLastYearSales = 0;
		nextWeekLastYearSales = 0;
		thisMonthLastYearSales = 0;
		lastMonthLastYearSales = 0;
		nextMonthLastYearSales = 0;

		nextWeekSales = 0;
		nextMonthSales = 0;

		calendar = Calendar.getInstance();
		today = Calendar.getInstance();

		lastWeek = Calendar.getInstance();
		twoWeeksAgo = Calendar.getInstance();
		threeWeeksAgo = Calendar.getInstance();
		lastMonth = Calendar.getInstance();
		twoMonthsAgo = Calendar.getInstance();
		threeMonthsAgo = Calendar.getInstance();

		thisWeekLastYear = Calendar.getInstance();
		lastWeekLastYear = Calendar.getInstance();
		nextWeekLastYear = Calendar.getInstance();
		thisMonthLastYear = Calendar.getInstance();
		lastMonthLastYear = Calendar.getInstance();
		nextMonthLastYear = Calendar.getInstance();

		lastWeek.add(Calendar.WEEK_OF_YEAR, -1);
		twoWeeksAgo.add(Calendar.WEEK_OF_YEAR, -2);
		threeWeeksAgo.add(Calendar.WEEK_OF_YEAR, -3);
		lastMonth.add(Calendar.MONTH, -1);
		twoMonthsAgo.add(Calendar.MONTH, -2);
		threeMonthsAgo.add(Calendar.MONTH, -3);

		thisWeekLastYear.add(Calendar.YEAR, -1);
		thisWeekLastYear.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR));
		lastWeekLastYear.add(Calendar.YEAR, -1);
		lastWeekLastYear.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) - 1);
		thisMonthLastYear.add(Calendar.YEAR, -1);
		lastMonthLastYear.add(Calendar.YEAR, -1);
		lastMonthLastYear.add(Calendar.MONTH, -1);

		nextWeekLastYear.add(Calendar.YEAR, -1);
		nextWeekLastYear.set(Calendar.WEEK_OF_YEAR,
				Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
		nextWeekLastYear.add(Calendar.WEEK_OF_YEAR, 1);
		nextMonthLastYear.add(Calendar.YEAR, -1);
		nextMonthLastYear.add(Calendar.MONTH, 1);

		System.out.println("This week" + calendar.getTime());
		System.out.println("Last week" + lastWeek.getTime());
		System.out.println("2 weeks ago " + twoWeeksAgo.getTime());
		System.out.println("3 week ago" + threeWeeksAgo.getTime());
		System.out.println("Last month" + lastMonth.getTime());
		System.out.println("2 week ago" + twoMonthsAgo.getTime());
		System.out.println("3 week ago" + threeMonthsAgo.getTime());
		System.out.println("this week last year" + thisWeekLastYear.getTime());
		System.out.println("Last week last year" + lastWeekLastYear.getTime());
		System.out
				.println("this month last year" + thisMonthLastYear.getTime());
		System.out
				.println("Last month last year" + lastMonthLastYear.getTime());
		System.out.println("next week last year" + nextWeekLastYear.getTime());
		System.out
				.println("next month last year" + nextMonthLastYear.getTime());

		for (Sale sale : sales) {

			Calendar saleDate = this.dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == calendar
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == calendar
							.get(Calendar.YEAR))) {
				thisWeekSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == lastWeek
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == lastWeek
							.get(Calendar.YEAR))) {
				lastWeekSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == twoWeeksAgo
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == twoWeeksAgo
							.get(Calendar.YEAR))) {
				twoWeekSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == threeWeeksAgo
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == threeWeeksAgo
							.get(Calendar.YEAR))) {
				threeWeekSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == calendar
							.get(Calendar.YEAR))) {
				thisMonthSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.MONTH) == lastMonth.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == lastMonth
							.get(Calendar.YEAR))) {
				lastMonthSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.MONTH) == twoMonthsAgo
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == twoMonthsAgo
							.get(Calendar.YEAR))) {
				twoMonthSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.MONTH) == threeMonthsAgo
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == threeMonthsAgo
							.get(Calendar.YEAR))) {
				threeMonthSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == nextWeekLastYear
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == nextWeekLastYear
							.get(Calendar.YEAR))) {
				nextWeekLastYearSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == thisWeekLastYear
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == thisWeekLastYear
							.get(Calendar.YEAR))) {
				thisWeekLastYearSales += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == lastWeekLastYear
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == lastWeekLastYear
							.get(Calendar.YEAR))) {
				lastWeekLastYearSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.MONTH) == lastMonthLastYear
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == lastMonthLastYear
							.get(Calendar.YEAR))) {
				lastMonthLastYearSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.MONTH) == thisMonthLastYear
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == thisMonthLastYear
							.get(Calendar.YEAR))) {
				thisMonthLastYearSales += sale.getTotalPrice();
			}

			if ((saleDate.get(Calendar.MONTH) == nextMonthLastYear
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == nextMonthLastYear
							.get(Calendar.YEAR))) {
				nextMonthLastYearSales += sale.getTotalPrice();
			}
		}

		System.out.println("This week " + thisWeekSales);
		System.out.println("last week " + lastWeekSales);
		System.out.println("two week " + twoWeekSales);
		System.out.println("three week " + threeWeekSales);
		System.out.println("This month " + thisMonthSales);
		System.out.println("last month " + lastMonthSales);
		System.out.println("two month " + twoMonthSales);
		System.out.println("three month " + threeMonthSales);
		System.out.println("this week last year " + thisWeekLastYearSales);
		System.out.println("last week last year " + lastWeekLastYearSales);
		System.out.println("This month last year " + thisMonthLastYearSales);
		System.out.println("last month last year " + lastMonthLastYearSales);
		System.out.println("next week last year " + nextWeekLastYearSales);
		System.out.println("next month last year " + nextMonthLastYearSales);

		nextWeekSales = ((((thisWeekSales / thisWeekLastYearSales) * 2) + (lastWeekSales / lastWeekLastYearSales)) / 3)
				* nextWeekLastYearSales;

		nextMonthSales = ((((thisMonthSales / thisMonthLastYearSales) * 2) + (lastMonthSales / lastMonthLastYearSales)) / 3)
				* nextMonthLastYearSales;

		System.out.println("Next week sales prediction " + nextWeekSales);

		System.out.println("Next month sales prediction " + nextMonthSales);

	}

	private void stockPredictor(ArrayList<Sale> sales, Stock stock) {

		thisWeekStockSales = 0;
		lastWeekStockSales = 0;
		twoWeekStockSales = 0;
		threeWeekStockSales = 0;
		thisMonthStockSales = 0;
		lastMonthStockSales = 0;
		twoMonthStockSales = 0;
		threeMonthStockSales = 0;
		thisWeekLastYearStockSales = 0;
		lastWeekLastYearStockSales = 0;
		nextWeekLastYearStockSales = 0;
		thisMonthLastYearStockSales = 0;
		lastMonthLastYearStockSales = 0;
		nextMonthLastYearStockSales = 0;

		nextWeekStockSales = 0;
		nextMonthStockSales = 0;

		calendar = Calendar.getInstance();
		today = Calendar.getInstance();

		lastWeek = Calendar.getInstance();
		twoWeeksAgo = Calendar.getInstance();
		threeWeeksAgo = Calendar.getInstance();
		lastMonth = Calendar.getInstance();
		twoMonthsAgo = Calendar.getInstance();
		threeMonthsAgo = Calendar.getInstance();

		thisWeekLastYear = Calendar.getInstance();
		lastWeekLastYear = Calendar.getInstance();
		nextWeekLastYear = Calendar.getInstance();
		thisMonthLastYear = Calendar.getInstance();
		lastMonthLastYear = Calendar.getInstance();
		nextMonthLastYear = Calendar.getInstance();

		lastWeek.add(Calendar.WEEK_OF_YEAR, -1);
		twoWeeksAgo.add(Calendar.WEEK_OF_YEAR, -2);
		threeWeeksAgo.add(Calendar.WEEK_OF_YEAR, -3);
		lastMonth.add(Calendar.MONTH, -1);
		twoMonthsAgo.add(Calendar.MONTH, -2);
		threeMonthsAgo.add(Calendar.MONTH, -3);

		thisWeekLastYear.add(Calendar.YEAR, -1);
		thisWeekLastYear.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR));
		lastWeekLastYear.add(Calendar.YEAR, -1);
		lastWeekLastYear.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) - 1);
		thisMonthLastYear.add(Calendar.YEAR, -1);
		lastMonthLastYear.add(Calendar.YEAR, -1);
		lastMonthLastYear.add(Calendar.MONTH, -1);

		nextWeekLastYear.add(Calendar.YEAR, -1);
		nextWeekLastYear.set(Calendar.WEEK_OF_YEAR,
				Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
		nextWeekLastYear.add(Calendar.WEEK_OF_YEAR, 1);
		nextMonthLastYear.add(Calendar.YEAR, -1);
		nextMonthLastYear.add(Calendar.MONTH, 1);

		System.out.println("This week" + calendar.getTime());
		System.out.println("Last week" + lastWeek.getTime());
		System.out.println("2 weeks ago " + twoWeeksAgo.getTime());
		System.out.println("3 week ago" + threeWeeksAgo.getTime());
		System.out.println("Last month" + lastMonth.getTime());
		System.out.println("2 week ago" + twoMonthsAgo.getTime());
		System.out.println("3 week ago" + threeMonthsAgo.getTime());
		System.out.println("this week last year" + thisWeekLastYear.getTime());
		System.out.println("Last week last year" + lastWeekLastYear.getTime());
		System.out
				.println("this month last year" + thisMonthLastYear.getTime());
		System.out
				.println("Last month last year" + lastMonthLastYear.getTime());
		System.out.println("next week last year" + nextWeekLastYear.getTime());
		System.out
				.println("next month last year" + nextMonthLastYear.getTime());

		for (Sale sale : sales) {

			Calendar saleDate = this.dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == calendar
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == calendar
							.get(Calendar.YEAR))) {
				// thisWeekSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						thisWeekStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == lastWeek
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == lastWeek
							.get(Calendar.YEAR))) {
				// lastWeekSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						lastWeekStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == twoWeeksAgo
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == twoWeeksAgo
							.get(Calendar.YEAR))) {
				// twoWeekSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						twoWeekStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == threeWeeksAgo
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == threeWeeksAgo
							.get(Calendar.YEAR))) {
				// threeWeekSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						threeWeekStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == calendar
							.get(Calendar.YEAR))) {
				// thisMonthSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						thisMonthStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == lastMonth.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == lastMonth
							.get(Calendar.YEAR))) {
				// lastMonthSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						lastMonthStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == twoMonthsAgo
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == twoMonthsAgo
							.get(Calendar.YEAR))) {
				// twoMonthSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						twoMonthStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == threeMonthsAgo
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == threeMonthsAgo
							.get(Calendar.YEAR))) {
				// threeMonthSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						threeMonthStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == nextWeekLastYear
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == nextWeekLastYear
							.get(Calendar.YEAR))) {
				// nextWeekLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						nextWeekLastYearStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == thisWeekLastYear
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == thisWeekLastYear
							.get(Calendar.YEAR))) {
				// thisWeekLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						thisWeekLastYearStockSales += sale.getTotalPrice();
					}
				}
			}
			if ((saleDate.get(Calendar.WEEK_OF_YEAR) == lastWeekLastYear
					.get(Calendar.WEEK_OF_YEAR))
					&& (saleDate.get(Calendar.YEAR) == lastWeekLastYear
							.get(Calendar.YEAR))) {
				// lastWeekLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						lastWeekLastYearStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == lastMonthLastYear
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == lastMonthLastYear
							.get(Calendar.YEAR))) {
				// lastMonthLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						lastMonthLastYearStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == thisMonthLastYear
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == thisMonthLastYear
							.get(Calendar.YEAR))) {
				// thisMonthLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						thisMonthLastYearStockSales += sale.getTotalPrice();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == nextMonthLastYear
					.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == nextMonthLastYear
							.get(Calendar.YEAR))) {
				// nextMonthLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						nextMonthLastYearStockSales += sale.getTotalPrice();
					}
				}
			}
		}

		nextWeekStockSales = ((((thisWeekStockSales / thisWeekLastYearStockSales) * 2) + (lastWeekStockSales / lastWeekLastYearStockSales)) / 3)
				* nextWeekLastYearStockSales;

		nextMonthStockSales = ((((thisMonthStockSales / thisMonthLastYearStockSales) * 2) + (lastMonthStockSales / lastMonthLastYearStockSales)) / 3)
				* nextMonthLastYearStockSales;

		System.out.println("Next week sales prediction for " + stock.getName()
				+ " " + nextWeekStockSales);
		System.out.println("Next month sales prediction for " + stock.getName()
				+ " " + nextMonthStockSales);
	}

	private Calendar dateToCalender(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}
