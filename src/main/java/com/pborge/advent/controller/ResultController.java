package com.pborge.advent.controller;

import com.pborge.advent.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Advent of Code", description = "After saving Christmas five years in a row, you've decided to take a vacation at a nice resort on a tropical island. Surely, Christmas will go on without you. The tropical island has its own currency and is entirely cash-only. The gold coins used there have a little picture of a starfish; the locals just call them stars. None of the currency exchanges seem to have heard of them, but somehow, you'll need to find fifty of these coins by the time you arrive so you can pay the deposit on your room. To save your vacation, you need to get all fifty stars by December 25th.")
public class ResultController {
    @Autowired
    private AdventServiceOne adventServiceOne;
    @Autowired
    private AdventServiceTwo adventServiceTwo;
    @Autowired
    private AdventServiceThree adventServiceThree;
    @Autowired
    private AdventServiceFour adventServiceFour;
    @Autowired
    private AdventServiceFive adventServiceFive;
    @Autowired
    private AdventServiceSix adventServiceSix;

    @RequestMapping(value = "/1/reportRepair", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up. Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.")
    public Integer reportRepair() {
        return adventServiceOne.getAdvent1Result();
    }

    @RequestMapping(value = "/1/reportRepair/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer reportRepairTwo() {
        return adventServiceOne.getAdvent2Result();
    }

    @RequestMapping(value = "/2/passwordPhilosophy", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Your flight departs in a few days from the coastal airport; the easiest way down to the coast from here is via toboggan. The shopkeeper at the North Pole Toboggan Rental Shop is having a bad day. \"Something's wrong with our computers; we can't log in!\" You ask if you can take a look. Their password database seems to be a little corrupted: some of the passwords wouldn't have been allowed by the Official Toboggan Corporate Policy that was in effect when they were chosen. To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the corrupted database) and the corporate policy when that password was set.")
    public Long passwordPhilosophy() {
        return adventServiceTwo.getAdvent1Result();
    }

    @RequestMapping(value = "/2/passwordPhilosophy/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Long passwordPhilosophyTwo() {
        return adventServiceTwo.getAdvent2Result();
    }

    @RequestMapping(value = "/3/tobogganTrajectory", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "With the toboggan login problems resolved, you set off toward the airport. While travel by toboggan might be easy, it's certainly not safe: there's very minimal steering and the area is covered in trees. You'll need to see which angles will take you near the fewest trees.")
    public Integer tobogganTrajectory() {
        return adventServiceThree.getAdvent1Result();
    }

    @RequestMapping(value = "/3/tobogganTrajectory/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Long tobogganTrajectoryTwo() {
        return adventServiceThree.getAdvent2Result();
    }

    @RequestMapping(value = "/4/passportProcessing", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "You arrive at the airport only to realize that you grabbed your North Pole Credentials instead of your passport. While these documents are extremely similar, North Pole Credentials aren't issued by a country and therefore aren't actually valid documentation for travel in most of the world. It seems like you're not the only one having problems, though; a very long line has formed for the automatic passport scanners, and the delay could upset your travel itinerary. Due to some questionable network security, you realize you might be able to solve both of these problems at the same time.")
    public Integer passportProcessing() {
        return adventServiceFour.getAdvent1Result();
    }

    @RequestMapping(value = "/4/passportProcessing/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer passportProcessingTwo() {
        return adventServiceFour.getAdvent2Result();
    }

    @RequestMapping(value = "/5/binaryBoarding", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "You board your plane only to discover a new problem: you dropped your boarding pass! You aren't sure which seat is yours, and all of the flight attendants are busy with the flood of people that suddenly made it through passport control. You write a quick program to use your phone's camera to scan all of the nearby boarding passes (your puzzle input); perhaps you can find your seat through process of elimination.")
    public Integer binaryBoarding() {
        return adventServiceFive.getAdvent1Result();
    }

    @RequestMapping(value = "/5/binaryBoarding/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer binaryBoardingTwo() {
        return adventServiceFive.getAdvent2Result();
    }

    @RequestMapping(value = "/6/customCustoms", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "As your flight approaches the regional airport where you'll switch to a much larger plane, customs declaration forms are distributed to the passengers. The form asks a series of 26 yes-or-no questions marked a through z. All you need to do is identify the questions for which anyone in your group answers \"yes\". Since your group is just you, this doesn't take very long. However, the person sitting next to you seems to be experiencing a language barrier and asks if you can help. For each of the people in their group, you write down the questions for which they answer \"yes\", one per line. Another group asks for your help, then another...")
    public Integer customCustoms() {
        return adventServiceSix.getAdvent1Result();
    }

    @RequestMapping(value = "/6/customCustoms/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer customCustomsTwo() {
        return adventServiceSix.getAdvent2Result();
    }
}
