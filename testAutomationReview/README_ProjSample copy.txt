This document represents my opinion on the current state of 
Test automation for Loyalty test auto repositories

Multi Tender Functional tests
Customer Value

My observations reinforce a perspective: The former test automaiton vision has drifted off course
Your comment about the test cases becoming a aggragation describes the way the vision and direction has drifted.

The name of the repo where I started my investigation is Multi Tender Functional tests.  It seems clear from test scripting, functional testing was the direction initially taken.
But, with the addition of Multi Tender Loyalty program, there as been code added that brings existing work into the Multi Tender Loyalty world.
This act clouds the vision of the original Functional tests. With the addition of an 'End to End' nature of Integrated Loyalty, the functional tests become nearly hidden.

A breakdown of the collection of testing would be a valuable asset.  
Each repository should also have some level of documentation that explains details as some agreed upon level.  





Observations, what do we have.
---------------------
we have a considerable collection of tests.  We have little or no documentation ( that I've seen ) that would explain vision, direction and current status.

   * Initially scripting Seems to be broken out by Functionality identified in script file names.  So, what are the functions:  Is there a list ?

   * Due to dedicatd effort of developers to add functionality over time, ( organizationally ) we have ended up not knowing how much of what we have, 
     nor how similar or different it is.  There are a few who individualy know some of what we have.  

   * Over time, some of the functional test have become a means of activiating or setting up the functions in the integrated loyalty system tests.
      * A good example is the points calculations being as the last step in a scenario, giving an End-To-End flavor to the collection of testing
      * The effect of this addtion means this script is no longer focusing on testing the functional operation.  
        * When Point calculation becomes the failure we have lost the functional evaluation of order cancellation testing.

   * We have a very larg problem of clean non changing test data.  I don't fully understand where all the data lives in the tesing of system
     Some of this work may be mocked.  One has to fully understand and dig to know for sure. ( documentation )

   * Your comment in a recents, "The testing has become aggragated".  I think that was the word you had used.  
     "Aggragated," conveyed the concept of tests becoming homogenious. 
     As noted earlier, the differentiation of original functionality is not as clear 

   * What have we lost in this change.
     * We no longer have identifiable subsets we can run ( or isolate from running ) for the following test conditions 
       Build acceptance, Regression Acceptance , Functional testing, Regression testing[ small | large ], End to End



Note: On the last major implementation of test automation, test functionality was defined by the page of a workflow so tracking scripting purpose was simpler




What do we need or what could we do.
---------------------

We need to know what we have 
   * On a repository basis we need the primary focus of each test script, and know if all scenarios per script focus on script subject. Generally this is the case.
   * On a sublevel we need to know how the individual scenarios deviate from each other.  This could be by good naming convention or with a tiny bit of documentation.
   * On a functional level or feature level what is our coverage.  
     * What determines proper coverage for a newly defined feature or function. ( Feature Completeness )
   - With this information:
     - We can accurately make purposfully segrated collections of tests.
     - Segragation give us the ability to make decisions about what to develop, or what to execute for specific reasons.
     - Most important, I think, We get vision on what is the highest priority work needed. Development in specific areas, running collections of tests in specific development cycles.


we need to know what it does
   * Some simple explanations: Order cancellation full, Order cancel partial, Order return, member enrollment, card to account assignment, account merge.
   * Is it a fully implemented system test, or are specific modules mocked?
   - Revivew and analysis can quickly provide a picture of is missing
   - Work necessary to catch up can be forcasted with better focus.



We need to know how to control test data :  "Partial wearhousing" .
   * This is one of the biggest issues GAP Testing might ever undertake, 
   * Only partial wearhousing, because I know we need to integrate testing to access Epsilon services .  
     We should not design all of our tests to return exact values ( IE:  My account should now display 2770 Points )
   * We need to be able to ask for a return of test data from our provider and simply validate the data format, not necessarily All of its values.
   - Accurate test evaluation of newly deployed code is returned when failing data is removed from the equation.


End-To-End Test Cases:
We Do not need to delete what has become end to end testing.  But we need to seperate it from functional, acceptance,and smoke testing code.
I think we can have a better collection of End to End tests if we take a step back and don't try to make every complicated functional tests an end to end tests.
We need a collection of end to end tests similir to what I've seen.  Just not a conversion of every existing Funtional test.










Put the whiney crap here
==========================================================================================================================================================

   * With so many similarly named files and no map / legend, we really dont know how much of what we have, nor how similar named items differ.

   * At some point the test cases start getting really big as if they were end to end TC
      * As an E2E Tc they needed to cancel several items in on purchase order.  So the order needed to have many items
      * we are no longer testing the cancel or return function. We are treating the cancel operation as a means ot activiating the loyalty system points calculation.

   * We have a very larg problem of clean non changing test data. Epsilon 
      * Clean means the data doesn't change.  Even after a test run, you can reset and get back to what you had, and what the TC is written to expect 
      * If we need to have aged data, we need to isolated the data and the tests that expect that to happen.
We also need end to end test cases, maybe just as many as we have now, but we dont want to loose the functional tests in the process.



Documentation

54 Test Script
420 Scenarios
3458 Steps

File naming pattern that is being used 
user_online_thin_return_transaction_all_brand_1##,  *_2##, up to 4, etc.
user_stores_transaction_ON_brand_1##, *_2##, 
