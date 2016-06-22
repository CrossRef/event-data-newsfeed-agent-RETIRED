# Event Data Newsfeed Agent

An Event Data agent for following news feeds in Atom and RSS format. Experimental.

## Running

### Add a feed to monitor

    lein with-profile dev run add-feed "http://feeds.feedburner.com/ResearchBloggingAllEnglish?format=xml"

## Working feed set

This is written to deal with Feedburner aggregated ResearchBlogging items where the reference list is included in the RSS feed. For other feeds slight tweaks might be necessary.

Taken from http://researchblogging.org/static/index/page/rss

 - http://feeds.feedburner.com/ResearchBloggingAllEnglish?format=xml
 - http://feeds.feedburner.com/ResearchBloggingAllChinese?format=xml
 - http://feeds.feedburner.com/ResearchBloggingAllGerman?format=xml
 - http://feeds.feedburner.com/ResearchBlogging-AllTopics-Italian?format=xml
 - http://feeds.feedburner.com/ResearchBlogging-AllTopics-Polish?format=xml
 - http://feeds.feedburner.com/ResearchBloggingAllPortuguese?format=xml
 - http://feeds.feedburner.com/ResearchBloggingAllSpanish?format=xml

Scienceseeker (these are on Joe's personal account)

 - http://www.inoreader.com/stream/user/1005830516/tag/Nutrition
 - http://www.inoreader.com/stream/user/1005830516/tag/Language
 - http://www.inoreader.com/stream/user/1005830516/tag/Political%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Political%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Uncategorized
 - http://www.inoreader.com/stream/user/1005830516/tag/Development
 - http://www.inoreader.com/stream/user/1005830516/tag/Geography
 - http://www.inoreader.com/stream/user/1005830516/tag/Marine%20Biology
 - http://www.inoreader.com/stream/user/1005830516/tag/Academic%20and%20Student%20Life%2C%20Careers%20and%20Grants
 - http://www.inoreader.com/stream/user/1005830516/tag/Science%20Press%20Releases
 - http://www.inoreader.com/stream/user/1005830516/tag/Philosophy
 - http://www.inoreader.com/stream/user/1005830516/tag/Social%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Political%20science%2C%20economics%2C%20history%2C%20social%20science%2C%20sociology%2C%20language%2C%20development%20and%20law.
 - http://www.inoreader.com/stream/user/1005830516/tag/Gender
 - http://www.inoreader.com/stream/user/1005830516/tag/Grants
 - http://www.inoreader.com/stream/user/1005830516/tag/Oceanography
 - http://www.inoreader.com/stream/user/1005830516/tag/Artificial%20Intelligence%2C%20Computer%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Law
 - http://www.inoreader.com/stream/user/1005830516/tag/Paleontology
 - http://www.inoreader.com/stream/user/1005830516/tag/Plant%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Publishing
 - http://www.inoreader.com/stream/user/1005830516/tag/Veterinary%20Medicine
 - http://www.inoreader.com/stream/user/1005830516/tag/Sociology
 - http://www.inoreader.com/stream/user/1005830516/tag/Academic%20Life
 - http://www.inoreader.com/stream/user/1005830516/tag/Clinical%20Research
 - http://www.inoreader.com/stream/user/1005830516/tag/Art
 - http://www.inoreader.com/stream/user/1005830516/tag/Climate%20Science%2C%20Conservation%2C%20Ecology%2C%20and%20Environment%20
 - http://www.inoreader.com/stream/user/1005830516/tag/Student%20Life
 - http://www.inoreader.com/stream/user/1005830516/tag/Religion%20and%20Atheism
 - http://www.inoreader.com/stream/user/1005830516/tag/Podcast
 - http://www.inoreader.com/stream/user/1005830516/tag/Photography
 - http://www.inoreader.com/stream/user/1005830516/tag/Education
 - http://www.inoreader.com/stream/user/1005830516/tag/Library%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Microbiology
 - http://www.inoreader.com/stream/user/1005830516/tag/Ethics
 - http://www.inoreader.com/stream/user/1005830516/tag/Policy
 - http://www.inoreader.com/stream/user/1005830516/tag/Career
 - http://www.inoreader.com/stream/user/1005830516/tag/Engineering
 - http://www.inoreader.com/stream/user/1005830516/tag/Energy
 - http://www.inoreader.com/stream/user/1005830516/tag/Conservation
 - http://www.inoreader.com/stream/user/1005830516/tag/Computer%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Clinical%20Psychology
 - http://www.inoreader.com/stream/user/1005830516/tag/Economics
 - http://www.inoreader.com/stream/user/1005830516/tag/Public%20Health
 - http://www.inoreader.com/stream/user/1005830516/tag/Mathematics
 - http://www.inoreader.com/stream/user/1005830516/tag/Climate%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Physics
 - http://www.inoreader.com/stream/user/1005830516/tag/Environment
 - http://www.inoreader.com/stream/user/1005830516/tag/Health
 - http://www.inoreader.com/stream/user/1005830516/tag/History
 - http://www.inoreader.com/stream/user/1005830516/tag/Behavioral%20Biology
 - http://www.inoreader.com/stream/user/1005830516/tag/Archeology
 - http://www.inoreader.com/stream/user/1005830516/tag/General%20Science
 - http://www.inoreader.com/stream/user/1005830516/tag/Science%20Communication
 - http://www.inoreader.com/stream/user/1005830516/tag/Anthropology
 - http://www.inoreader.com/stream/user/1005830516/tag/Ecology
 - http://www.inoreader.com/stream/user/1005830516/tag/Psychiatry
 - http://www.inoreader.com/stream/user/1005830516/tag/Astronomy
 - http://www.inoreader.com/stream/user/1005830516/tag/Evolution
 - http://www.inoreader.com/stream/user/1005830516/tag/Geosciences
 - http://www.inoreader.com/stream/user/1005830516/tag/Chemistry
 - http://www.inoreader.com/stream/user/1005830516/tag/Medicine
 - http://www.inoreader.com/stream/user/1005830516/tag/Cell%20Biology
 - http://www.inoreader.com/stream/user/1005830516/tag/Biology
 - http://www.inoreader.com/stream/user/1005830516/tag/Biotechnology
 - http://www.inoreader.com/stream/user/1005830516/tag/Artificial%20Intelligence
 - http://www.inoreader.com/stream/user/1005830516/tag/Psychology
 - http://www.inoreader.com/stream/user/1005830516/tag/Neuroscience


## License

Copyright © 2016 Crossref

Distributed under the MIT license.