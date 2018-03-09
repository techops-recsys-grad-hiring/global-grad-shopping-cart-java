# Introduction

This codebase is used during in-office pairing session (Code Laundry) for JOI initiative in North America.
It's focused on identifying code smells, refactoring, testing legacy codebase while promoting
conversations around various testing strategies, design strategies etc.

## Problem Statement
We have an existing shopping cart application, with a small set of eCommerce/shopping cart rules. Rules include calculation of total price, discount and loyalty points calculation. Most of the business logic is implemented in single method ShoppingCart.checkout.

## Extension tasks
1. Implement a discount of 20%, the products eligible for which will be identified by the product code starting with "DIS_20". On purchase of each such product, the customer earns, 1 loyalty point for every $20 spent

2. Implement an offer on group of products, eg. "Buy 2 get 1 free" on specific products identified by product code starting with "BULK_BUY_2_GET_1"

3. Implement a discount of 5% which is applicable on total purchase above $500


