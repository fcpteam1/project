package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class StockSalesPredictor {

	Calendar calendar;
	Calendar today, yesterday, twoDaysAgo, threeDaysAgo, fourDaysAgo,
			fiveDaysAgo, sixDaysAgo;
	Calendar weekBeginning, weekEnding, lastWeekBeginning,
			twoWeeksAgoBeginning, threeWeeksAgoBeginning, lastWeekEnding,
			twoWeeksAgoEnding, threeWeeksAgoEnding;
	Calendar lastWeek, twoWeeksAgo, threeWeeksAgo;
	Calendar lastMonth, twoMonthsAgo, threeMonthsAgo;
	Calendar thisWeekLastYear, lastWeekLastYear, nextWeekLastYear,
			thisWeekLastYearBeginning, lastWeekLastYearBeginning,
			nextWeekLastYearBeginning, thisWeekLastYearEnding,
			lastWeekLastYearEnding, nextWeekLastYearEnding;
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

	public StockSalesPredictor() {
		// TODO Auto-generated constructor stub

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
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		weekBeginning = Calendar.getInstance();

		weekBeginning.add(Calendar.DATE, -(day) + 2);
		weekBeginning.set(Calendar.HOUR, 0);
		weekEnding = Calendar.getInstance();
		weekEnding.add(Calendar.DATE, -(day) + 8);
		weekEnding.set(Calendar.HOUR, 23);
		// lastWeek = Calendar.getInstance();
		// twoWeeksAgo = Calendar.getInstance();
		// threeWeeksAgo = Calendar.getInstance();
		lastWeekBeginning = Calendar.getInstance();
		twoWeeksAgoBeginning = Calendar.getInstance();
		threeWeeksAgoBeginning = Calendar.getInstance();
		lastWeekEnding = Calendar.getInstance();
		twoWeeksAgoEnding = Calendar.getInstance();
		threeWeeksAgoEnding = Calendar.getInstance();

		lastMonth = Calendar.getInstance();
		twoMonthsAgo = Calendar.getInstance();
		threeMonthsAgo = Calendar.getInstance();

		// thisWeekLastYear = Calendar.getInstance();
		// lastWeekLastYear = Calendar.getInstance();
		// nextWeekLastYear = Calendar.getInstance();

		thisWeekLastYearBeginning = Calendar.getInstance();
		lastWeekLastYearBeginning = Calendar.getInstance();
		nextWeekLastYearBeginning = Calendar.getInstance();

		thisWeekLastYearEnding = Calendar.getInstance();
		lastWeekLastYearEnding = Calendar.getInstance();
		nextWeekLastYearEnding = Calendar.getInstance();

		thisMonthLastYear = Calendar.getInstance();
		lastMonthLastYear = Calendar.getInstance();
		nextMonthLastYear = Calendar.getInstance();

		// lastWeek.add(Calendar.WEEK_OF_YEAR, -1);
		// twoWeeksAgo.add(Calendar.WEEK_OF_YEAR, -2);
		// threeWeeksAgo.add(Calendar.WEEK_OF_YEAR, -3);

		lastWeekBeginning.add(Calendar.DATE, -(day) + 2 - 7);
		lastWeekBeginning.set(Calendar.HOUR, 0);
		twoWeeksAgoBeginning.add(Calendar.DATE, -(day) + 2 - 14);
		twoWeeksAgoBeginning.set(Calendar.HOUR, 0);
		threeWeeksAgoBeginning.add(Calendar.DATE, -(day) + 2 - 21);
		threeWeeksAgoBeginning.set(Calendar.HOUR, 0);

		lastWeekEnding.add(Calendar.DATE, -(day) + 8 - 7);
		lastWeekEnding.set(Calendar.HOUR, 23);
		twoWeeksAgoEnding.add(Calendar.DATE, -(day) + 8 - 14);
		twoWeeksAgoEnding.set(Calendar.HOUR, 23);
		threeWeeksAgoEnding.add(Calendar.DATE, -(day) + 8 - 21);
		threeWeeksAgoEnding.set(Calendar.HOUR, 23);

		lastMonth.add(Calendar.MONTH, -1);
		twoMonthsAgo.add(Calendar.MONTH, -2);
		threeMonthsAgo.add(Calendar.MONTH, -3);

		thisWeekLastYearBeginning.add(Calendar.YEAR, -1);
		thisWeekLastYearBeginning.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR));
		thisWeekLastYearBeginning.add(Calendar.DATE,
				-(thisWeekLastYearBeginning.get(Calendar.DAY_OF_WEEK)) + 2);
		thisWeekLastYearBeginning.set(Calendar.HOUR, 0);

		thisWeekLastYearEnding.add(Calendar.YEAR, -1);
		thisWeekLastYearEnding.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR));
		thisWeekLastYearEnding.add(Calendar.DATE,
				-(thisWeekLastYearEnding.get(Calendar.DAY_OF_WEEK)) + 8);
		thisWeekLastYearEnding.set(Calendar.HOUR, 23);

		lastWeekLastYearBeginning.add(Calendar.YEAR, -1);
		lastWeekLastYearBeginning.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) - 1);
		lastWeekLastYearBeginning.add(Calendar.DATE,
				-(lastWeekLastYearBeginning.get(Calendar.DAY_OF_WEEK)) + 2);
		lastWeekLastYearBeginning.set(Calendar.HOUR, 0);

		lastWeekLastYearEnding.add(Calendar.YEAR, -1);
		lastWeekLastYearEnding.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) - 1);
		lastWeekLastYearEnding.add(Calendar.DATE,
				-(lastWeekLastYearEnding.get(Calendar.DAY_OF_WEEK)) + 8);
		lastWeekLastYearEnding.set(Calendar.HOUR, 23);

		thisMonthLastYear.add(Calendar.YEAR, -1);
		lastMonthLastYear.add(Calendar.YEAR, -1);
		lastMonthLastYear.add(Calendar.MONTH, -1);

		nextWeekLastYearBeginning.add(Calendar.YEAR, -1);
		nextWeekLastYearBeginning.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) + 1);
		nextWeekLastYearBeginning.add(Calendar.DATE,
				-(nextWeekLastYearBeginning.get(Calendar.DAY_OF_WEEK)) + 2);
		nextWeekLastYearBeginning.set(Calendar.HOUR, 0);

		nextWeekLastYearEnding.add(Calendar.YEAR, -1);
		nextWeekLastYearEnding.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) + 1);
		nextWeekLastYearEnding.add(Calendar.DATE,
				-(nextWeekLastYearEnding.get(Calendar.DAY_OF_WEEK)) + 8);
		nextWeekLastYearEnding.set(Calendar.HOUR, 23);

		// nextWeekLastYear.add(Calendar.WEEK_OF_YEAR, 1);
		nextMonthLastYear.add(Calendar.YEAR, -1);
		nextMonthLastYear.add(Calendar.MONTH, 1);

		// System.out.println("This week" + calendar.getTime());
		System.out.println("This week begiing " + weekBeginning.getTime());
		System.out.println("This week ending " + weekEnding.getTime());
		// System.out.println("Last week" + lastWeek.getTime());
		System.out.println("last week begiing " + lastWeekBeginning.getTime());
		System.out.println("last week ending " + lastWeekEnding.getTime());
		// System.out.println("2 weeks ago " + twoWeeksAgo.getTime());
		System.out.println("2 week begiing " + twoWeeksAgoBeginning.getTime());
		System.out.println("2 week ending " + twoWeeksAgoEnding.getTime());
		// System.out.println("3 week ago" + threeWeeksAgo.getTime());
		System.out
				.println("3 week begiing " + threeWeeksAgoBeginning.getTime());
		System.out.println("3 week ending " + threeWeeksAgoEnding.getTime());
		System.out.println("Last month" + lastMonth.getTime());
		System.out.println("2 month ago" + twoMonthsAgo.getTime());
		System.out.println("3 month ago" + threeMonthsAgo.getTime());
		System.out.println("this week last year beginning"
				+ thisWeekLastYearBeginning.getTime());
		System.out.println("this week last year ending "
				+ thisWeekLastYearEnding.getTime());
		System.out.println("Last week last year beginning"
				+ lastWeekLastYearBeginning.getTime());
		System.out.println("Last week last year ending "
				+ lastWeekLastYearEnding.getTime());
		System.out
				.println("this month last year" + thisMonthLastYear.getTime());
		System.out
				.println("Last month last year" + lastMonthLastYear.getTime());
		System.out.println("next week last year beginning"
				+ nextWeekLastYearBeginning.getTime());
		System.out.println("next week last year ending "
				+ nextWeekLastYearEnding.getTime());
		System.out
				.println("next month last year" + nextMonthLastYear.getTime());

		for (Sale sale : sales) {

			Calendar saleDate = this.dateToCalender(sale.getDate());

			if ((saleDate.after(weekBeginning))
					&& (saleDate.before(weekEnding))) {
				thisWeekSales += sale.getTotalPrice();
			}

			if ((saleDate.after(lastWeekBeginning))
					&& (saleDate.before(lastWeekEnding))) {
				lastWeekSales += sale.getTotalPrice();
			}

			if ((saleDate.after(twoWeeksAgoBeginning))
					&& (saleDate.before(twoWeeksAgoEnding))) {
				twoWeekSales += sale.getTotalPrice();
			}

			if ((saleDate.after(threeWeeksAgoBeginning))
					&& (saleDate.before(threeWeeksAgoEnding))) {
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

			if ((saleDate.after(nextWeekLastYearBeginning))
					&& (saleDate.before(nextWeekLastYearEnding))) {
				nextWeekLastYearSales += sale.getTotalPrice();
			}

			if ((saleDate.after(thisWeekLastYearBeginning))
					&& (saleDate.before(thisWeekLastYearEnding))) {
				thisWeekLastYearSales += sale.getTotalPrice();
			}
			if ((saleDate.after(lastWeekLastYearBeginning))
					&& (saleDate.before(lastWeekLastYearEnding))) {
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

		int daysGone = calendar.get(Calendar.DAY_OF_WEEK);
		daysGone -= 1;
		if (daysGone == 0)
			daysGone = 7;

		thisWeekSales = (thisWeekSales / daysGone) * 7;

		nextWeekSales = ((((thisWeekSales / thisWeekLastYearSales) * 2) + (lastWeekSales / lastWeekLastYearSales)) / 3)
				* nextWeekLastYearSales;
		if (nextWeekSales == 0) {
			nextWeekSales = ((thisWeekSales * 4) + (lastWeekSales * 3)
					+ (twoWeekSales * 2) + (threeWeekSales)) / 10;
		}

		thisMonthSales = thisMonthSales / calendar.get(Calendar.DATE)
				* calendar.getMaximum(calendar.get(Calendar.MONTH));

		nextMonthSales = ((((thisMonthSales / thisMonthLastYearSales) * 2) + (lastMonthSales / lastMonthLastYearSales)) / 3)
				* nextMonthLastYearSales;

		if (nextMonthSales == 0) {
			nextMonthSales = ((thisMonthSales * 4) + (lastMonthSales * 3)
					+ (twoMonthSales * 2) + (threeMonthSales)) / 10;
		}

		System.out.println("Next week sales prediction " + nextWeekSales);

		System.out.println("Next month sales prediction " + nextMonthSales);

	}

	public int[] stockPredictor(ArrayList<Sale> sales, Stock stock, boolean week) {

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
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		weekBeginning = Calendar.getInstance();

		weekBeginning.add(Calendar.DATE, -(day) + 2);
		weekBeginning.set(Calendar.HOUR, 0);
		weekEnding = Calendar.getInstance();
		weekEnding.add(Calendar.DATE, -(day) + 8);
		weekEnding.set(Calendar.HOUR, 23);
		// lastWeek = Calendar.getInstance();
		// twoWeeksAgo = Calendar.getInstance();
		// threeWeeksAgo = Calendar.getInstance();
		lastWeekBeginning = Calendar.getInstance();
		twoWeeksAgoBeginning = Calendar.getInstance();
		threeWeeksAgoBeginning = Calendar.getInstance();
		lastWeekEnding = Calendar.getInstance();
		twoWeeksAgoEnding = Calendar.getInstance();
		threeWeeksAgoEnding = Calendar.getInstance();

		lastMonth = Calendar.getInstance();
		twoMonthsAgo = Calendar.getInstance();
		threeMonthsAgo = Calendar.getInstance();

		// thisWeekLastYear = Calendar.getInstance();
		// lastWeekLastYear = Calendar.getInstance();
		// nextWeekLastYear = Calendar.getInstance();

		thisWeekLastYearBeginning = Calendar.getInstance();
		lastWeekLastYearBeginning = Calendar.getInstance();
		nextWeekLastYearBeginning = Calendar.getInstance();

		thisWeekLastYearEnding = Calendar.getInstance();
		lastWeekLastYearEnding = Calendar.getInstance();
		nextWeekLastYearEnding = Calendar.getInstance();

		thisMonthLastYear = Calendar.getInstance();
		lastMonthLastYear = Calendar.getInstance();
		nextMonthLastYear = Calendar.getInstance();

		// lastWeek.add(Calendar.WEEK_OF_YEAR, -1);
		// twoWeeksAgo.add(Calendar.WEEK_OF_YEAR, -2);
		// threeWeeksAgo.add(Calendar.WEEK_OF_YEAR, -3);

		lastWeekBeginning.add(Calendar.DATE, -(day) + 2 - 7);
		lastWeekBeginning.set(Calendar.HOUR, 0);
		twoWeeksAgoBeginning.add(Calendar.DATE, -(day) + 2 - 14);
		twoWeeksAgoBeginning.set(Calendar.HOUR, 0);
		threeWeeksAgoBeginning.add(Calendar.DATE, -(day) + 2 - 21);
		threeWeeksAgoBeginning.set(Calendar.HOUR, 0);

		lastWeekEnding.add(Calendar.DATE, -(day) + 8 - 7);
		lastWeekEnding.set(Calendar.HOUR, 23);
		twoWeeksAgoEnding.add(Calendar.DATE, -(day) + 8 - 14);
		twoWeeksAgoEnding.set(Calendar.HOUR, 23);
		threeWeeksAgoEnding.add(Calendar.DATE, -(day) + 8 - 21);
		threeWeeksAgoEnding.set(Calendar.HOUR, 23);

		lastMonth.add(Calendar.MONTH, -1);
		twoMonthsAgo.add(Calendar.MONTH, -2);
		threeMonthsAgo.add(Calendar.MONTH, -3);

		thisWeekLastYearBeginning.add(Calendar.YEAR, -1);
		thisWeekLastYearBeginning.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR));
		thisWeekLastYearBeginning.add(Calendar.DATE,
				-(thisWeekLastYearBeginning.get(Calendar.DAY_OF_WEEK)) + 2);
		thisWeekLastYearBeginning.set(Calendar.HOUR, 0);

		thisWeekLastYearEnding.add(Calendar.YEAR, -1);
		thisWeekLastYearEnding.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR));
		thisWeekLastYearEnding.add(Calendar.DATE,
				-(thisWeekLastYearEnding.get(Calendar.DAY_OF_WEEK)) + 8);
		thisWeekLastYearEnding.set(Calendar.HOUR, 23);

		lastWeekLastYearBeginning.add(Calendar.YEAR, -1);
		lastWeekLastYearBeginning.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) - 1);
		lastWeekLastYearBeginning.add(Calendar.DATE,
				-(lastWeekLastYearBeginning.get(Calendar.DAY_OF_WEEK)) + 2);
		lastWeekLastYearBeginning.set(Calendar.HOUR, 0);

		lastWeekLastYearEnding.add(Calendar.YEAR, -1);
		lastWeekLastYearEnding.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) - 1);
		lastWeekLastYearEnding.add(Calendar.DATE,
				-(lastWeekLastYearEnding.get(Calendar.DAY_OF_WEEK)) + 8);
		lastWeekLastYearEnding.set(Calendar.HOUR, 23);

		thisMonthLastYear.add(Calendar.YEAR, -1);
		lastMonthLastYear.add(Calendar.YEAR, -1);
		lastMonthLastYear.add(Calendar.MONTH, -1);

		nextWeekLastYearBeginning.add(Calendar.YEAR, -1);
		nextWeekLastYearBeginning.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) + 1);
		nextWeekLastYearBeginning.add(Calendar.DATE,
				-(nextWeekLastYearBeginning.get(Calendar.DAY_OF_WEEK)) + 2);
		nextWeekLastYearBeginning.set(Calendar.HOUR, 0);

		nextWeekLastYearEnding.add(Calendar.YEAR, -1);
		nextWeekLastYearEnding.set(Calendar.WEEK_OF_YEAR,
				calendar.get(Calendar.WEEK_OF_YEAR) + 1);
		nextWeekLastYearEnding.add(Calendar.DATE,
				-(nextWeekLastYearEnding.get(Calendar.DAY_OF_WEEK)) + 8);
		nextWeekLastYearEnding.set(Calendar.HOUR, 23);

		// nextWeekLastYear.add(Calendar.WEEK_OF_YEAR, 1);
		nextMonthLastYear.add(Calendar.YEAR, -1);
		nextMonthLastYear.add(Calendar.MONTH, 1);

		// System.out.println("This week" + calendar.getTime());
		System.out.println("This week begiing " + weekBeginning.getTime());
		System.out.println("This week ending " + weekEnding.getTime());
		// System.out.println("Last week" + lastWeek.getTime());
		System.out.println("last week begiing " + lastWeekBeginning.getTime());
		System.out.println("last week ending " + lastWeekEnding.getTime());
		// System.out.println("2 weeks ago " + twoWeeksAgo.getTime());
		System.out.println("2 week begiing " + twoWeeksAgoBeginning.getTime());
		System.out.println("2 week ending " + twoWeeksAgoEnding.getTime());
		// System.out.println("3 week ago" + threeWeeksAgo.getTime());
		System.out
				.println("3 week begiing " + threeWeeksAgoBeginning.getTime());
		System.out.println("3 week ending " + threeWeeksAgoEnding.getTime());
		System.out.println("Last month" + lastMonth.getTime());
		System.out.println("2 month ago" + twoMonthsAgo.getTime());
		System.out.println("3 month ago" + threeMonthsAgo.getTime());
		System.out.println("this week last year beginning"
				+ thisWeekLastYearBeginning.getTime());
		System.out.println("this week last year ending "
				+ thisWeekLastYearEnding.getTime());
		System.out.println("Last week last year beginning"
				+ lastWeekLastYearBeginning.getTime());
		System.out.println("Last week last year ending "
				+ lastWeekLastYearEnding.getTime());
		System.out
				.println("this month last year" + thisMonthLastYear.getTime());
		System.out
				.println("Last month last year" + lastMonthLastYear.getTime());
		System.out.println("next week last year beginning"
				+ nextWeekLastYearBeginning.getTime());
		System.out.println("next week last year ending "
				+ nextWeekLastYearEnding.getTime());
		System.out
				.println("next month last year" + nextMonthLastYear.getTime());

		for (Sale sale : sales) {

			Calendar saleDate = this.dateToCalender(sale.getDate());

			if ((saleDate.after(weekBeginning))
					&& (saleDate.before(weekEnding))) {
				// thisWeekSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						// thisWeekStockSales += sale.getTotalPrice();
						thisWeekStockSales += saleStock.getQuantity();
					}
				}
			}

			if ((saleDate.after(lastWeekBeginning))
					&& (saleDate.before(lastWeekEnding))) {
				// lastWeekSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						lastWeekStockSales += saleStock.getQuantity();
					}
				}
			}

			if ((saleDate.after(twoWeeksAgoBeginning))
					&& (saleDate.before(twoWeeksAgoEnding))) {
				// twoWeekSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						twoWeekStockSales += saleStock.getQuantity();
					}
				}
			}

			if ((saleDate.after(threeWeeksAgoBeginning))
					&& (saleDate.before(threeWeeksAgoEnding))) {
				// threeWeekSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						threeWeekStockSales += saleStock.getQuantity();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == calendar
							.get(Calendar.YEAR))) {
				// thisMonthSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						thisMonthStockSales += saleStock.getQuantity();
					}
				}
			}

			if ((saleDate.get(Calendar.MONTH) == lastMonth.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == lastMonth
							.get(Calendar.YEAR))) {
				// lastMonthSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						lastMonthStockSales += saleStock.getQuantity();
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
						twoMonthStockSales += saleStock.getQuantity();
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
						threeMonthStockSales += saleStock.getQuantity();
					}
				}
			}

			if ((saleDate.after(nextWeekLastYearBeginning))
					&& (saleDate.before(nextWeekLastYearEnding))) {
				// nextWeekLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						nextWeekLastYearStockSales += saleStock.getQuantity();
					}
				}
			}

			if ((saleDate.after(thisWeekLastYearBeginning))
					&& (saleDate.before(thisWeekLastYearEnding))) {
				// thisWeekLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						thisWeekLastYearStockSales += saleStock.getQuantity();
					}
				}
			}
			if ((saleDate.after(lastWeekLastYearBeginning))
					&& (saleDate.before(lastWeekLastYearEnding))) {
				// lastWeekLastYearSales += sale.getTotalPrice();
				for (Stock saleStock : sale.getStocks()) {
					if (saleStock.getName().equals(stock.getName())) {
						lastWeekLastYearStockSales += saleStock.getQuantity();
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
						lastMonthLastYearStockSales += saleStock.getQuantity();
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
						thisMonthLastYearStockSales += saleStock.getQuantity();
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
						nextMonthLastYearStockSales += saleStock.getQuantity();
					}
				}
			}
		}

		int daysGone = calendar.get(Calendar.DAY_OF_WEEK);
		daysGone -= 1;
		thisWeekStockSales = (thisWeekStockSales / daysGone) * 7;

		nextWeekStockSales = ((((thisWeekStockSales / thisWeekLastYearStockSales) * 2) + (lastWeekStockSales / lastWeekLastYearStockSales)) / 3)
				* nextWeekLastYearStockSales;
		if (nextWeekStockSales == 0) {
			nextWeekStockSales = ((thisWeekStockSales * 4)
					+ (lastWeekStockSales * 3) + (twoWeekStockSales * 2) + (threeWeekStockSales)) / 10;
		}

		thisMonthStockSales = thisMonthStockSales / calendar.get(Calendar.DATE)
				* calendar.getMaximum(calendar.get(Calendar.MONTH));

		nextMonthStockSales = ((((thisMonthStockSales / thisMonthLastYearStockSales) * 2) + (lastMonthStockSales / lastMonthLastYearStockSales)) / 3)
				* nextMonthLastYearStockSales;

		if (nextMonthStockSales == 0) {
			nextMonthStockSales = ((thisMonthStockSales * 4)
					+ (lastMonthStockSales * 3) + (twoMonthStockSales * 2) + (threeMonthStockSales)) / 10;
		}

		System.out.println("Next week sales prediction for " + stock.getName()
				+ " " + nextWeekStockSales);
		System.out.println("Next month sales prediction for " + stock.getName()
				+ " " + nextMonthStockSales);

		int result[] = new int[5];

		if (week == true) {
			result[0] = (int) threeWeekStockSales;
			result[1] = (int) twoWeekStockSales;
			result[2] = (int) lastWeekStockSales;
			result[3] = (int) thisWeekStockSales;
			result[4] = (int) nextWeekStockSales;
		} else {
			result[0] = (int) threeMonthStockSales;
			result[1] = (int) twoMonthStockSales;
			result[2] = (int) lastMonthStockSales;
			result[3] = (int) thisMonthStockSales;
			result[4] = (int) nextMonthStockSales;
		}

		return result;
	}

	private Calendar dateToCalender(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}
