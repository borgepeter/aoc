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
    @Autowired
    private AdventServiceFifteen adventServiceFifteen;
    @Autowired
    private AdventServiceSixteen adventServiceSixteen;
    @Autowired
    private AdventServiceSeventeen adventServiceSeventeen;
    @Autowired
    private AdventServiceEighteen adventServiceEighteen;
    @Autowired
    private AdventServiceNineteen adventServiceNineteen;
    @Autowired
    private AdventServiceTwenty adventServiceTwenty;
    @Autowired
    private AdventServiceTwentyOne adventServiceTwentyOne;
    @Autowired
    private AdventServiceTwentyTwo adventServiceTwentyTwo;
    @Autowired
    private AdventServiceTwentyThree adventServiceTwentyThree;
    @Autowired
    private AdventServiceTwentyFour adventServiceTwentyFour;
    @Autowired
    private AdventServiceTwentyFive adventServiceTwentyFive;

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
    public Long shuttleSearchTwo() {
        return adventServiceThirteen.getAdvent2Result();
    }

    @RequestMapping(value = "/14/dockingData", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "As your ferry approaches the sea port, the captain asks for your help again. The computer system that runs this port isn't compatible with the docking program on the ferry, so the docking parameters aren't being correctly initialized in the docking program's memory. After a brief inspection, you discover that the sea port's computer system uses a strange bitmask system in its initialization program. Although you don't have the correct decoder chip handy, you can emulate it in software!")
    public Long dockingData() {
        return adventServiceFourteen.getAdvent1Result();
    }

    @RequestMapping(value = "/14/dockingData/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Long dockingDataTwo() {
        return adventServiceFourteen.getAdvent2Result();
    }

    @RequestMapping(value = "/15/rambunctiousRecitation", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "You catch the airport shuttle and try to book a new flight to your vacation island. Due to the storm, all direct flights have been cancelled, but a route is available to get around the storm. You take it. While you wait for your flight, you decide to check in with the Elves back at the North Pole. They're playing a memory game and are ever so excited to explain the rules!")
    public Integer rambunctiousRecitation() {
        return adventServiceFifteen.getAdvent1Result();
    }

    @RequestMapping(value = "/15/rambunctiousRecitation/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer rambunctiousRecitationTwo() {
        return adventServiceFifteen.getAdvent2Result();
    }

    @RequestMapping(value = "/16/ticketTranslation", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "As you're walking to yet another connecting flight, you realize that one of the legs of your re-routed trip coming up is on a high-speed train. However, the train ticket you were given is in a language you don't understand. You should probably figure out what it says before you get to the train station after the next flight...")
    public Integer ticketTranslation() {
        return adventServiceSixteen.getAdvent1Result();
    }

    @RequestMapping(value = "/16/ticketTranslation/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Long ticketTranslationTwo() {
        return adventServiceSixteen.getAdvent2Result();
    }

    @RequestMapping(value = "/17/conwayCubes", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "As your flight slowly drifts through the sky, the Elves at the Mythical Information Bureau at the North Pole contact you. They'd like some help debugging a malfunctioning experimental energy source aboard one of their super-secret imaging satellites. The experimental energy source is based on cutting-edge technology: a set of Conway Cubes contained in a pocket dimension! When you hear it's having problems, you can't help but agree to take a look...")
    public Integer conwayCubes() {
        return adventServiceSeventeen.getAdvent1Result();
    }

    @RequestMapping(value = "/17/conwayCubes/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer conwayCubesTwo() {
        return adventServiceSeventeen.getAdvent2Result();
    }

    @RequestMapping(value = "/18/operationOrder", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "As you look out the window and notice a heavily-forested continent slowly appear over the horizon, you are interrupted by the child sitting next to you. They're curious if you could help them with their math homework...")
    public Long operationOrder() {
        return adventServiceEighteen.getAdvent1Result();
    }

    @RequestMapping(value = "/18/operationOrder/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Long operationOrderTwo() {
        return adventServiceEighteen.getAdvent2Result();
    }

    @RequestMapping(value = "/19/monsterMessages", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "You land in an airport surrounded by dense forest. As you walk to your high-speed train, the Elves at the Mythical Information Bureau contact you again. They think their satellite has collected an image of a sea monster! Unfortunately, the connection to the satellite is having problems, and many of the messages sent back from the satellite have been corrupted....")
    public Integer monsterMessages() {
        return adventServiceNineteen.getAdvent1Result();
    }

    @RequestMapping(value = "/19/monsterMessages/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer monsterMessagesTwo() {
        return adventServiceNineteen.getAdvent2Result();
    }

    @RequestMapping(value = "/20/jurassicJigsaw", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "The high-speed train leaves the forest and quickly carries you south. You can even see a desert in the distance! Since you have some spare time, you might as well see if there was anything interesting in the image the Mythical Information Bureau satellite captured. After decoding the satellite messages, you discover that the data actually contains many small images created by the satellite's camera array. The camera array consists of many cameras; rather than produce a single square image, they produce many smaller square image tiles that need to be reassembled back into a single image...")
    public Long jurassicJigsaw() {
        return adventServiceTwenty.getAdvent1Result();
    }

    @RequestMapping(value = "/20/monsterMessages/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer jurassicJigsawTwo() {
        return adventServiceTwenty.getAdvent2Result();
    }

    @RequestMapping(value = "/21/allergenAssessment", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "You reach the train's last stop and the closest you can get to your vacation island without getting wet. There aren't even any boats here, but nothing can stop you now: you build a raft. You just need a few days' worth of food for your journey. You don't speak the local language, so you can't read any ingredients lists. However, sometimes, allergens are listed in a language you do understand. You should be able to use this information to determine which ingredient contains which allergen and work out which foods are safe to take with you on your trip...")
    public Integer allergenAssessment() {
        return adventServiceTwentyOne.getAdvent1Result();
    }

    @RequestMapping(value = "/21/allergenAssessment/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer allergenAssessmentTwo() {
        return adventServiceTwentyOne.getAdvent2Result();
    }

    @RequestMapping(value = "/22/crabCombat", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "It only takes a few hours of sailing the ocean on a raft for boredom to sink in. Fortunately, you brought a small deck of space cards! You'd like to play a game of Combat, and there's even an opponent available: a small crab that climbed aboard your raft before you left. Fortunately, it doesn't take long to teach the crab the rules...")
    public Integer crabCombat() {
        return adventServiceTwentyTwo.getAdvent1Result();
    }

    @RequestMapping(value = "/22/crabCombat/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer crabCombatTwo() {
        return adventServiceTwentyTwo.getAdvent2Result();
    }

    @RequestMapping(value = "/23/crabCups", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "The small crab challenges you to a game! The crab is going to mix up some cups, and you have to predict where they'll end up...")
    public Integer crabCups() {
        return adventServiceTwentyThree.getAdvent1Result();
    }

    @RequestMapping(value = "/23/crabCups/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer crabCupsTwo() {
        return adventServiceTwentyThree.getAdvent2Result();
    }

    @RequestMapping(value = "/24/lobbyLayout", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Your raft makes it to the tropical island; it turns out that the small crab was an excellent navigator. You make your way to the resort. As you enter the lobby, you discover a small problem: the floor is being renovated. You can't even reach the check-in desk until they've finished installing the new tile floor...")
    public Integer lobbyLayout() {
        return adventServiceTwentyFour.getAdvent1Result();
    }

    @RequestMapping(value = "/24/lobbyLayout/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer lobbyLayoutTwo() {
        return adventServiceTwentyFour.getAdvent2Result();
    }

    @RequestMapping(value = "/25/comboBreaker", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "You finally reach the check-in desk. Unfortunately, their registration systems are currently offline, and they cannot check you in. Noticing the look on your face, they quickly add that tech support is already on the way! They even created all the room keys this morning; you can take yours now and give them your room deposit once the registration system comes back online. The room key is a small RFID card. Your room is on the 25th floor and the elevators are also temporarily out of service, so it takes what little energy you have left to even climb the stairs and navigate the halls. You finally reach the door to your room, swipe your card, and - beep - the light turns red. Examining the card more closely, you discover a phone number for tech support. \"Hello! How can we help you today?\" You explain the situation. \"Well, it sounds like the card isn't sending the right command to unlock the door. If you go back to the check-in desk, surely someone there can reset it for you.\" Still catching your breath, you describe the status of the elevator and the exact number of stairs you just had to climb. \"I see! Well, your only other option would be to reverse-engineer the cryptographic handshake the card does with the door and then inject your own commands into the data stream, but that's definitely impossible.\" You thank them for their time. Unfortunately for the door, you know a thing or two about cryptographic handshakes...")
    public Integer comboBreaker() {
        return adventServiceTwentyFive.getAdvent1Result();
    }

    @RequestMapping(value = "/25/comboBreaker/2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("Part 2")
    public Integer comboBreakerTwo() {
        return adventServiceTwentyFive.getAdvent2Result();
    }
}
