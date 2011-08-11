package org.oliveruv.circulus.client;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import org.oliveruv.circulus.client.resources.BundledResources;
import org.oliveruv.circulus.shared.NewsItem;
import org.oliveruv.circulus.shared.ReleaseItem;
import org.oliveruv.circulus.shared.ReleaseTrack;
import org.oliveruv.circulus.shared.Ukuria;

public class ContentProvider {
	
	private final BundledResources res;
	private ArrayList<NewsItem> newsItems;
	private HashMap<String, ReleaseItem> releases;
	private HashMap<String, Ukuria> ukuria;

	@Inject
	public ContentProvider(BundledResources res) {
		this.res = res;
		this.newsItems = getNews();
		this.releases = getReleases();
		this.ukuria = generateUkuria();
	}

	private HashMap<String, Ukuria> generateUkuria() {
		HashMap<String, Ukuria> ukuria = new HashMap<String, Ukuria>();
		
		Ukuria u = new Ukuria("doting", "Doting dreamer of fortune's everlasting favours", new Label("Flowing blue rivers of higher unusual clouds of choosing deepen into lakes of beautiful visions hosting delicate heaps of loving exploits. Welcome ideas flood down cheering euphoric wails instigating wondrous calls of divine drumming from the doting dreamer of fortune's everlasting favours reaching you with fragrant feelings of medicinal decicisions healing energies unifying constant hesitant thoughts riding rich thoroughbreds through vales of shining visions sending kisses uniting flocks of divided gentlemen with ideas with help from children, daisies and beautiful ladies ending all you fear in times of fearing preparing unimaginable possibilities heading our way when higher vibrations open doorways in our heads flooding deep caverns with notions of ever widening wonder and rich thoughts of loving maps closing chasms with trusting closeness cheating jealousy with unending visions of earthly freedom from blowing winds of derision. Be doubtless when sending wishes using craters of certainty for unbelievable results. Know that every resting thought can rise into brilliant bounty with clever control inventing clouds of drifting ecstacy eliminating worrying yearnings of weakness and resistance following cool clear gulleys of love and giving moving closer to godliness you find perfect cosiness and everlasting happiness."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		u = new Ukuria("ecstacy", "Ecstacy closes weakness", new Label("Truth emerges when the rising gates of drumming thinkers win the fight against well wearing bigots who were voted into power by themselves. Hear your dark tutors slate the very ideas they kidded you with before we lost freedoms, useless new laws imposed to make us more subservient and less responsible for our own well being. Feel delight that their phony diligence verifies their vulgarity undermining every last well delivered deceit used on us to blind us from common sense and who we really are. Question why ideas so utterly wasteful shine upon us from blinding lights of humourless halfwits using controlled wars to demoralise us as loving creators of dreamlike realities we use chronic thoughts of death and destruction instead of greatness and togetherness. Give no more thought to politicians and teachers of innumerable attrocities when you can teach of kindness and love where modest freedom means everyone can visualise and create a world of tenderness and compassion eveolving us all we can taste true harmony under loving skies."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		u = new Ukuria("reach", "Energy flows where you reach", new Label("Rising creation in rich throws of music through heavenly strings the sharing of trust using energy you can unify steering with bright open roads into valleys of folding soft gentle hills where steps help you understand worrying is wastful when questions of doubts take you out of dense happiness teaching you how to return to the feeling of wondrous being in raptures of beauty where trust gives you over to deep worlds of growing the seeds of creation opening visions with feelings of short distances waiting to be worded in stories of wonder for showing us heroes in endless travels to where walls of forts crumble revealing clouds of deep turquoise tunes which shine under lights dissolving feelings of shock dotted traumas until energy drops endless brightness through windows of dry reason stripping gusts of easy hording from buildings inside the city of sorrow housing all our uncertainties making way for tall rising towers of clear toiless unification singing songs to bring solutions in waves of sudden ecstacy moving both fear and questioning right out of the way hiding unforgivingness silencing vices kept in pockets of long since worn overcoats left in wardrobes of moodiness telling old tales of stupidness using music to lift us we strive for true godliness giving ribbons of boldness to friends and acquaintances visualising energies working around us we reach out for triggers of fortune."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		u = new Ukuria("beyond", "Everybody is holding wisdom beyond hoards of treasure", new Label("Luck operates opens worlds of choices we make elevating distant yellow walls diverting unwanted feelings with techniques developed great eons ago physics allowed darts of divinity to seed ideas reserving welcome situations the energy to materialise forming happy scenes of bright hours on fertile islands tears of everlasting joy creat musical Utopia re-opening craters of sacred ground chosen for crossing slotting calmness under vest to escape thoughts of sinking under dry cracks forgetting where chasms deepen diving simply requesting you be overcome with feelings of clarity and take shining steps toward everlasting bliss while we enter creation's choisest plot dancing and levitating we eliminate weaknesses with desire for total serenity while rising upwards to godliness in time for unbelievable future of collective unrest dividing your consciousness we must better protect all the souls through feelings of empathy visualising outnumbered departures unto freedom and mutiny gaining visions of geography manifesting definingly clear lights creating great levels of free realisation focussing on sweet moving rivers in deserts of broken christian ideologies ending your intelligent belief that life ends when you stop breathing join up with happiness we nibble at rich teachings before nearing bright open tunnels bringing us mental future ravines of deep illuminated dreams ending in stories of glowing senses free from mutated mind traps set to steal your otherworldliness hear these words of Utopian dimensions and lift your minds in expected readiness we reach out easing suffering from unwanted systems of failing politicians knowing freedom comes rushing when you feel from the heart easing fruits of fortune eating succulent shades of undivided trust in your own power to decide your future using laws inscribed for desired destiny."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		u = new Ukuria("willing", "Falling rather willingly", new Label("Great times are opening with arrival of different midsummer calender hours giving whole new tender take on every aspect of life. Fertile thoughts lost in the fractured knots imposed by negative control systems begin to grow amongst inspired deliverers of glowing births helping vast numbers of virtuous engineers bring unimaginable houses of chosen thoughts into muffled minds mending switches in withering voiced cloaked up followers of betroved bringers of bad news leaving behind unworthy demonic and wicked loitering leaders giving unsavoury definitions of how they think good people should behave. Destined for goodness we can through unified thoughts convert vast heavens everywhere ending systems of constant wars for the gain of the few and the sorrow of many. Inside each one of us lies the power to bring lost universal healing upon our earth shifting knowledge of understanding away from the praises of christian worship toward the brighter vision of creation where all that we are rises when love and kindness unfolds around us visualising bitterness far away stitching new garments in unbelievable colours we sing to open new doorways with loving rhymes we cover each thought of cowardness with everlasting yearning for whole new worlds of unified forgiveness and feelings of fortune. "));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		u = new Ukuria("churches", "Heal dead churches", new Label("Dying churches you can heal with definite decisions of dangerous criticism undermining all yesterdays lies bubbling beneath centuries of bullying bishops wanting greater control over every soul with delusion and venomous witicisms muddying our minds with twisted truth forgetting who Jesus Christ fortold of hear my words there will be false prophets come to deceive you with stories of fear under false talking clergymen and crass creators of vulgarity. Dry knowledge comes upon us from sources long hidden finishing both vatican and churches everywhere. Each wondrous cathedral and sacred sanctuary can now declare visions of euphoric delight giving clear citation for the empowering of each individual with depictions of clocks showing us flowing new ideas to bring us all together leaving behind hatred and wars designed to deceive us all from our own true divinity."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		u = new Ukuria("tomorrow", "Hold feelings, hold slow, hold tomorrow", new Label("Elevate remembering you can work free wonders with your found indestructable knowledge luck will open Hobbit holes where time exacts all ears to hear in undivided visions uniting duration every second tossing tissues on the nation who wont believe its coming with other ecstatic wonders time will unwind until tomorrow becomes caught by man in trust asking you don't hide your doubt show it to me and I will fade your uncertainty with automatic frequencies to re-aline you structurally with crafts been known for centuries knowledge freedom accelerates bringing focus waiting upwards takes us to godly phosphorous skies knowing love will teach us how to ease tunnels music purifies your energy shifting dark unwanted matter afar quelling softly all intrusive evil found in other music to keep you imprisoned enraging people with seething vibrations where all they denied themselves of was peacefully waiting under their noses deciding now is the time to deepen our divine consciousness with centuries your ever widening world quelling timidity using love and unity flowing ever toward greater wisdom pulling effortlessly covering volumes of coded words falling in easy rising lucky flutters high and mighty choosing beauty and mobility."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		u = new Ukuria("doubt", "I tell of doubting christians and how best to use these castles", new Label("Follow only daring roads which lead us to futures filled with visions of beauty and greatness beyond setting suns. I vacate dry churches always empty of escaping future's daunting dilemas. Each unbelieving visitor wonders who can rush into God's sanctuary to deal with vicars and priests whose answers bringeth hope and humbleness without certainty or ideals. People come under creators not followers of joyless doctrines who end their lives in heaven or hell according to how each rat is hoping their time on earth shall be judged. Let us fling open these doors for every creator doing undeniable good and team together worshipping our own divinity as workers of positive flowing sacred energy for the love of our own true service to bring peace on earth with everlasting numbers of satisfied visitors creating visions of joy and to end all wars."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		u = new Ukuria("divinity", "Know your divinity", new Label("Visions of true blue skies seeing sunlight unfold in streams of pure untainted white beams of cords heating us housing us in shared thoughts feeling wide rich unity slowly flowing opening thoughts of clear gut instinct showing us how knowing with certainty grows valuable futures kindness can rise inside each pleasant individual sucking out all unforgivingness with endless sympathy energising notions of doting love inviting chosen wishes diverting with better exactness heavenly visions directly evolving us widening with attentive lovingness feeling thoughts deepening us waiting patiently for houses of collective flocks of inspired beings to grow with deep kindness gathering wide expansions of clear white mansions visiting drifting dimensions glowing brightly under questions of unfigured situations falling through what pleasing ideas we wish to grow joining cuddly feelings with universal healing through tunnels of inventiveness we choose love and rising consciousness to find timeless divinity reaching upwards for clarity singing songs of affinity telling tales to bring harmony hearing tones that lift unbelievable tranquility dulling notions of hostility calling sleep undividedly in beds of intuitiveness ending all situations of war and destructiveness using our minds to bring healing to all of us distancing feelings of clouds of fearfulness wishing for who we can become society gets indivisible oneness through unforgatable changes intensions will join us housing knowledge of freedom we rise to a kingdom inspired by thoughts of loving and slow realisation now know your divinity."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);

		u = new Ukuria("answers", "Send out your demands for whole new answers", new Label("Dealing in vast certainty giving brightness you ultimate birth of daring ideas questioning thought structure deepening offerings of old wisdom rare and unspoken gaining understanding viewing birth as a wave of energy tapped from the gulf of divine guests inside the house of the creator. Holding thoughts of destiny beyond this world leaving behind thoughts of safe endings forgetting ideas of verified weakness holding you back from rising energy holding you down with talk of terminating thought when your head raged heart leaves your body. Create whatever you wish for with complete certainty feeling your happiness answered have unified visions seeing worlds of loving knots diverse wearers of wealth and comfort with durable visions of virtue and understanding. You deny all shallow feelings of uncomfortable ears hearing your higher verbal testimonies speak in loving photographs of your everlasting joy. Feel unbroken gasses knowing energy favours beauty shirking gentle advancing reasoning programmed into our minds. Have disused waiting time hauled away making room for visions of endless wonder in your fortune and your strength. Rise higher holding daily rings of energising raids on dark feelings knocking aside all feelings of fear and uncloseness. Oppresive worries luck takes away and luck dissolves them all. Creation wears a golden coat joyously woven in feelings of ecstatic love."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);

		u = new Ukuria("delights", "Visions of joining rings of watery dished up delights", new Label("Fragrant whole tidy crystals of delicate white feelings glowing timelessly holding together endless lives with fluidlike density giving brilliant white clarity illuminating kindness in beams of worded nighing tears you feel overjoyous in your hurrying destinies gaining lucky little insights into days forever brings glorious energies far beyond present we hide no uncovered beauty begging all to sit in wonder as ready as you can for innocence opens up deep everywhere and resumes its mighty hold becoming sweeter giving civilisation deeper compassion with deity in each individual opening long forgotten distant doorways chemistry faded now chemistry allows us all to choose a shifting path winning every chance we take and rising upwardly diving unfearingly into blue lakes of burning gain if we visualise chrome feelings of everlasting universal love and truth to widen us always."));
		u.getContent().setStyleName(res.css().mediaText());
		ukuria.put(u.getUrlTitle(), u);
		
		FlowPanel p = new FlowPanel();
		HTML h;
		h = new HTML("To the tune of Greensleeves");
		h.setStyleName(res.css().mediaTextIndent());
		p.add(h);
		
		h = new HTML("Wistful voices with attitudes<br/>Waves forever you can't undermine<br/>Dove opening wings crest of wonder<br/>Mother of all her beauty");
		h.setStyleName(res.css().contentText());
		p.add(h);
		
		h = new HTML("Feel so happy for sorrows we tame<br/>Feel so happy for sorrows we tame<br/>Feel so happy for sorrows we tame<br/>Eliminiating muddiness");
		h.setStyleName(res.css().contentText());
		p.add(h);
		
		h = new HTML("Are you ready for fragrant brightness<br/>Reaching loving tasting her<br/>From the atoms of curiosity<br/>Bringing us dreams of euphopia");
		h.setStyleName(res.css().contentText());
		p.add(h);
		
		h = new HTML("Feel so happy for sorrows we tame<br/>Feel so happy for sorrows we tame<br/>Feel so happy for sorrows we tame<br/>Finishing all our worryings");
		h.setStyleName(res.css().contentText());
		p.add(h);
		
		h = new HTML("From curiosity gods may drastically<br/>Raid the teachers of brittle doom<br/>Sending sorrows far away<br/>Ending all today's doubting");
		h.setStyleName(res.css().contentText());
		p.add(h);
		
		h = new HTML("Feel so happy for sorrows we tame<br/>Feel so happy for sorrows we tame<br/>Feel so happy for sorrows we tame<br/>Life is a thing of such beauty");
		h.setStyleName(res.css().contentText());
		p.add(h);
		
		u = new Ukuria("tame", "Feel so happy for sorrows we tame", p);
		ukuria.put(u.getUrlTitle(), u);
		
		return ukuria;
	}

	public HashMap<String, Ukuria> getUkuria() {
		return this.ukuria;
	}
	
	private HashMap<String, ReleaseItem> getReleases() {
		ReleaseItem giantism = new ReleaseItem("giantism", "Giantism", 1999, "Instant Farma", "EP", res.giantism());
		ArrayList<ReleaseTrack> giantismTracks = new ArrayList<ReleaseTrack>();
		giantismTracks.add(new ReleaseTrack(1, "Little Big Song", 5, 7));
		giantismTracks.add(new ReleaseTrack(2, "The True Lover's Farewell", 3, 54));
		giantismTracks.add(new ReleaseTrack(3, "My Lady Carey's Dompe", 2, 55));
		giantismTracks.add(new ReleaseTrack(4, "Everglade", 4, 39));
		giantismTracks.add(new ReleaseTrack(5, "Sombrero Fallout", 3, 40));
		giantismTracks.add(new ReleaseTrack(6, "All You People", 9, 14));
		giantism.setTracks(giantismTracks);
		
		ReleaseItem lick = new ReleaseItem("lick", "The Lick on the Tip of an Envelope Yet to Be Sent", 2005, "Rise Above Records", "Album", res.lick());
		ArrayList<ReleaseTrack> lickTracks = new ArrayList<ReleaseTrack>();
		lickTracks.add(new ReleaseTrack(1, "Miri It Is", 2, 36));
		lickTracks.add(new ReleaseTrack(2, "My Body Is Made of Sunlight", 3, 54));
		lickTracks.add(new ReleaseTrack(3, "The Scarecrow", 4, 56));
		lickTracks.add(new ReleaseTrack(4, "Orpheus", 3, 7));
		lickTracks.add(new ReleaseTrack(5, "We Are Long Lost", 5, 34));
		lickTracks.add(new ReleaseTrack(6, "Swallow", 3, 59));
		lickTracks.add(new ReleaseTrack(7, "The Aphid", 5, 19));
		lickTracks.add(new ReleaseTrack(8, "Candlelight", 3, 28));
		lickTracks.add(new ReleaseTrack(9, "Power to the Pixies", 6, 14));
		lick.setTracks(lickTracks);
		
		ArrayList<String> lickReviews = new ArrayList<String>();
		lickReviews.add("http://www.nme.com/reviews/circulus/7703");
		lickReviews.add("http://pitchfork.com/reviews/albums/1822-lick-on-the-tip-of-an-envelope-thats-yet-to-be-sent/");
		lick.setReviewUrls(lickReviews);
		
		
		ReleaseItem clocks = new ReleaseItem("clocks", "Clocks Are Like People", 2006, "Rise Above Records", "Album", res.clocks());
		ArrayList<ReleaseTrack> clocksTracks = new ArrayList<ReleaseTrack>();
		clocksTracks.add(new ReleaseTrack(1, "Dragon's Dance", 3, 20));
		clocksTracks.add(new ReleaseTrack(2, "Song of Our Despair", 4, 57));
		clocksTracks.add(new ReleaseTrack(3, "Willow Tree", 4, 56));
		clocksTracks.add(new ReleaseTrack(4, "Wherever She Goes", 4, 18));
		clocksTracks.add(new ReleaseTrack(5, "Velocity Races", 4, 3));
		clocksTracks.add(new ReleaseTrack(6, "To the Fields", 3, 22));
		clocksTracks.add(new ReleaseTrack(7, "Bouree", 3, 17));
		clocksTracks.add(new ReleaseTrack(8, "This Is the Way", 5, 34));
		clocksTracks.add(new ReleaseTrack(9, "Reality's a Fantasy", 8, 22));
		clocks.setTracks(clocksTracks);
		
		ArrayList<String> clocksReviews = new ArrayList<String>();
		clocksReviews.add("http://www.spiralearth.co.uk/reviews/clockpeople.asp");
		clocks.setReviewUrls(clocksReviews);
		
		ReleaseItem thought = new ReleaseItem("thought", "Thought Becomes Reality", 2009, "Mythical Cake", "Album", res.thought());
		ArrayList<ReleaseTrack> thoughtTracks = new ArrayList<ReleaseTrack>();
		thoughtTracks.add(new ReleaseTrack(1, "Transmuting Power", 4, 31));
		thoughtTracks.add(new ReleaseTrack(2, "Fortunate Ones", 2, 57));
		thoughtTracks.add(new ReleaseTrack(3, "Guide Our Way", 3, 34));
		thoughtTracks.add(new ReleaseTrack(4, "Michael's Garden", 3, 11));
		thoughtTracks.add(new ReleaseTrack(5, "Trotto", 2, 16));
		thoughtTracks.add(new ReleaseTrack(6, "Packingtons Pound", 3, 42));
		thoughtTracks.add(new ReleaseTrack(7, "Sumer Is Incumen In", 3, 15));
		thoughtTracks.add(new ReleaseTrack(8, "Tristans Laments", 4, 9));
		thoughtTracks.add(new ReleaseTrack(9, "Kalenda Maya", 4, 17));
		thoughtTracks.add(new ReleaseTrack(10, "Within You Is The Sun", 4, 30));
		thought.setTracks(thoughtTracks);
		
		ArrayList<String> thoughtReviews = new ArrayList<String>();
		thoughtReviews.add("http://strangeglue.com/reviews/circulus-thought-becomes-reality");
		thought.setReviewUrls(thoughtReviews);
		
		HashMap<String, ReleaseItem> r = new HashMap<String, ReleaseItem>();
		r.put(thought.getKey(), thought);
		r.put(clocks.getKey(), clocks);
		r.put(lick.getKey(), lick);
		r.put(giantism.getKey(), giantism);
		return r;
	}

	private ArrayList<NewsItem> getNews() {
		ArrayList<NewsItem> items = new ArrayList<NewsItem>();
		items.add(new NewsItem(
				new Date(2011, 8, 10),
				"Oliver Uvman",
				"Updated some visual parts of the site. We've opened the door for wisdoms from Ukuria, blessed."));
		items.add(new NewsItem(
				new Date(2011, 8, 07),
				"Oliver Uvman",
				"Finally! We've managed to resume communications with the world. The web sight is up. Hope you like it!"));
		
		return items;
	}
	
	/***
	 * Returns a number of news items starting from the most recent.
	 * @param index 0 is the most recent item
	 * @return A list of widgets, each containing a news item.
	 */
	public List<Widget> getNewsItems(int index, int numberOfItems) {
		if(index >= newsItems.size() || numberOfItems == 0) return new ArrayList<Widget>();
		
		int upperIndex = Math.min(index+numberOfItems, newsItems.size());
		List<NewsItem> selectedNewsItems = newsItems.subList(index, upperIndex);
		List<Widget> newsWidgets = new ArrayList<Widget>();
		
		for (NewsItem item : selectedNewsItems) {
			newsWidgets.add(generateWidget(item));
		}
		return newsWidgets;
	}
	
	public Widget getLatestNews() {
		List<Widget> items = getNewsItems(0, 1);
		if(items.isEmpty()) {
			return new Label("No news :(");
		} else {
			return items.get(0);
		}
	}
	
	public boolean hasNewsItem(int indexNumber) {
		return newsItems.size() > indexNumber;
	}
	
	public Widget getGreeting() {
		FlowPanel p = new FlowPanel();
		
		Label greetingTitle = new Label("Welcome to the land of Circulus.");
		greetingTitle.setStyleName(res.css().contentTitle());
		p.add(greetingTitle);
		
		Label greetingText = new Label("Here is a land where you will find minstralism, mushroom sound tracks and maidens locked away in castles in the left side of the brain.");
		greetingText.setStyleName(res.css().contentText());
		p.add(greetingText);
		
		Label greetingText21 = new Label("These present days are bountiful with access to many delightful realms.");
		greetingText21.setStyleName(res.css().contentText());
		p.add(greetingText21);
		
		Label greetingText2 = new Label("Early music, psychedelia and obscure releases by forgotten bands from the seventies all configure into the Circulus sound.");
		greetingText2.setStyleName(res.css().contentText());
		p.add(greetingText2);

		Label greetingText3 = new Label("Our aim is to bring you fresh vibrations as often as we can. Soon, we'll have some free music for you to download.");
		greetingText3.setStyleName(res.css().contentText());
		p.add(greetingText3);
		
		return p;
	}
	
	private Widget generateWidget(NewsItem newsItem) {
		FlowPanel p = new FlowPanel();
		
		Label dateLabel = new Label(newsItem.getTimeString());
		dateLabel.setStyleName(res.css().contentText());
		dateLabel.addStyleName(res.css().newsDate()); 
		p.add(dateLabel);
		
		Label contentLabel = new Label(newsItem.getContents());
		contentLabel.setStyleName(res.css().contentText());
		contentLabel.addStyleName(res.css().newsContent());
		p.add(contentLabel);

		Label authorLabel = new Label("- " + newsItem.getAuthor());
		authorLabel.setStyleName(res.css().contentText());
		authorLabel.addStyleName(res.css().newsAuthor());
		p.add(authorLabel);
		
		return p;
	}
	
	public Widget getBiography() {
		Label l = new Label("Sorry, no bio yet! Just read the wikipedia article for now. Top left-ish.");
		l.setStyleName(res.css().contentText());
		return l;
	}

	public HashMap<String, ReleaseItem> getDiscography() {
		return releases;
	}

	public String getMostRecentAlbumName() {
		String albumName = "thought";
		int age = 0;
		for (ReleaseItem i : releases.values()) {
			if (age == 0 || age > i.getYear()) {
				albumName = i.getKey();
				age = i.getYear();
			}
		}
		return albumName;
	}
}
