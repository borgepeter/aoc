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
    @Autowired
    private AdventServiceSeven adventServiceSeven;
    @Autowired
    private AdventServiceEight adventServiceEight;
    @Autowired
    private AdventServiceNine adventServiceNine;
    @Autowired
    private AdventServiceTen adventServiceTen;
    @Autowired
    private AdventServiceEleven adventServiceEleven;
    @Autowired
    private AdventServiceTwelve adventServiceTwelve;
    @Autowired
    private AdventServiceThirteen adventServiceThirteen;
    @Autowired
    private AdventServiceFourteen adventServiceFourteen;

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

    @RequestMapping(value = "/7/handyHaversacks", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "You land at the regional airport in time for your next flight. In fact, it looks like you'll even have time to grab some food: all flights are currently delayed due to issues in luggage processing. Due to recent aviation regulations, many rules (your puzzle input) are being enforced about bags and their contents; bags must be color-coded and must contain specific quantities of other color-coded bags. Apparently, nobody responsible for these regulations considered how long they would take to enforce!")
    public Integer handyHaversacks() {
        return adventServiceSeven.getAdvent1Result();
    }

    @RequestMapping(value = "/7/handyHaversacks/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer handyHaversacksTwo() {
        return adventServiceSeven.getAdvent2Result();
    }

    @RequestMapping(value = "/8/handheldHalting", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Your flight to the major airline hub reaches cruising altitude without incident. While you consider checking the in-flight menu for one of those drinks that come with a little umbrella, you are interrupted by the kid sitting next to you. Their handheld game console won't turn on! They ask if you can take a look...")
    public Integer handheldHalting() {
        return adventServiceEight.getAdvent1Result();
    }

    @RequestMapping(value = "/8/handheldHalting/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer handheldHaltingTwo() {
        return adventServiceEight.getAdvent2Result();
    }

    @RequestMapping(value = "/9/encodingError", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "With your neighbor happily enjoying their video game, you turn your attention to an open data port on the little screen in the seat in front of you. Though the port is non-standard, you manage to connect it to your computer through the clever use of several paperclips. Upon connection, the port outputs a series of numbers. The data appears to be encrypted with the eXchange-Masking Addition System (XMAS) which, conveniently for you, is an old cypher with an important weakness...")
    public Long encodingError() {
        return adventServiceNine.getAdvent1Result();
    }

    @RequestMapping(value = "/9/encodingError/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Long encodingErrorTwo() {
        return adventServiceNine.getAdvent2Result();
    }

    @RequestMapping(value = "/10/adapterArray", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Patched into the aircraft's data port, you discover weather forecasts of a massive tropical storm. Before you can figure out whether it will impact your vacation plans, however, your device suddenly turns off! Its battery is dead. You'll need to plug it in...")
    public Integer adapterArray() {
        return adventServiceTen.getAdvent1Result();
    }

    @RequestMapping(value = "/10/adapterArray/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Long adapterArrayTwo() {
        return adventServiceTen.getAdvent2Result();
    }

    @RequestMapping(value = "/11/seatingSystem", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Your plane lands with plenty of time to spare. The final leg of your journey is a ferry that goes directly to the tropical island where you can finally start your vacation. As you reach the waiting area to board the ferry, you realize you're so early, nobody else has even arrived yet! By modeling the process people use to choose (or abandon) their seat in the waiting area, you're pretty sure you can predict the best place to sit. You make a quick map of the seat layout...")
    public Integer seatingSystem() {
        return adventServiceEleven.getAdvent1Result();
    }

    @RequestMapping(value = "/11/seatingSystem/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer seatingSystemTwo() {
        return adventServiceEleven.getAdvent2Result();
    }

    @RequestMapping(value = "/12/rainRisk", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Your ferry made decent progress toward the island, but the storm came in faster than anyone expected. The ferry needs to take evasive actions! Unfortunately, the ship's navigation computer seems to be malfunctioning; rather than giving a route directly to safety, it produced extremely circuitous instructions. When the captain uses the PA system to ask if anyone can help, you quickly volunteer...")
    public Integer rainRisk() {
        return adventServiceTwelve.getAdvent1Result();
    }

    @RequestMapping(value = "/12/rainRisk/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer rainRiskTwo() {
        return adventServiceTwelve.getAdvent2Result();
    }

    @RequestMapping(value = "/13/shuttleSearch", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Your ferry can make it safely to a nearby port, but it won't get much further. When you call to book another ship, you discover that no ships embark from that port to your vacation island. You'll need to get from the port to the nearest airport. Fortunately, a shuttle bus service is available to bring you from the sea port to the airport!")
    public Integer shuttleSearch() {
        return adventServiceThirteen.getAdvent1Result();
    }

    @RequestMapping(value = "/13/shuttleSearch/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer shuttleSearchTwo() {
        return adventServiceThirteen.getAdvent2Result();
    }

    @RequestMapping(value = "/14/dockingData", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "As your ferry approaches the sea port, the captain asks for your help again. The computer system that runs this port isn't compatible with the docking program on the ferry, so the docking parameters aren't being correctly initialized in the docking program's memory. After a brief inspection, you discover that the sea port's computer system uses a strange bitmask system in its initialization program. Although you don't have the correct decoder chip handy, you can emulate it in software!")
    public Integer dockingData() {
        return adventServiceFourteen.getAdvent1Result();
    }

    @RequestMapping(value = "/14/dockingData/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer dockingDataTwo() {
        return adventServiceFourteen.getAdvent2Result();
    }
}
